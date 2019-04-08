package dev.sillerud.lnwallet.activites.settings

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v7.preference.PreferenceManager
import android.util.Base64
import android.widget.Toast
import dev.sillerud.lnwallet.LightningConnectionInfo
import dev.sillerud.lnwallet.Network
import dev.sillerud.lnwallet.R
import dev.sillerud.lnwallet.activites.ActivityBase
import dev.sillerud.lnwallet.createLightningStub
import io.grpc.ManagedChannel
import kotlinx.android.synthetic.main.activity_wallet_settings.*
import kotlinx.coroutines.runBlocking
import lnrpc.Rpc
import java.io.File

class WalletSettingsActivity : ActivityBase() {
    private var requestCode: Int = -1
    var certificateBytes: ByteArray? = null
    var macaroonBytes: ByteArray? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wallet_settings)
        getLaunchConnectionInfo()?.let { connectionInfo ->
            lnHost.setText("${connectionInfo.host}:${connectionInfo.port}")
            walletName.setText(connectionInfo.name)
            certificateBytes = connectionInfo.certificate
            macaroonBytes = connectionInfo.macaroon
        }
        requestCode = intent.getIntExtra("requestCode", requestCode)

        buttonSelectCertificate.setOnClickListener {
            startActivityForResult(Intent(Intent.ACTION_GET_CONTENT).apply {
                type = "file/*"
            }, CERTIFICATE_RESULT)
        }
        buttonSelectMacaroon.setOnClickListener {
            startActivityForResult(Intent(Intent.ACTION_GET_CONTENT).apply {
                type = "file/*"
            }, MACAROON_RESULT)
        }

        buttonAdd.setOnClickListener {
            val connectionParts = lnHost.text.split(":")
            if (certificateBytes == null) {
                Toast.makeText(this, "Certificate is missing", Toast.LENGTH_SHORT).show()
            }
            if (macaroonBytes == null) {
                Toast.makeText(this, "Macaroon is missing", Toast.LENGTH_SHORT).show()
            }
            // TODO: IPv6
            if (connectionParts.size != 2) {
                Toast.makeText(this, "Host format is host:port", Toast.LENGTH_SHORT).show()
            }
            val hostName = connectionParts[0]
            val port = connectionParts[1].toInt()
            val initialConnectionInfo = LightningConnectionInfo(
                connectionId = currentConnectionId!!,
                host = hostName,
                port = port,
                macaroon = macaroonBytes!!,
                certificate = certificateBytes!!,
                network = null,
                name = walletName.text?.toString()
            )

            val network = getNetworkFor(initialConnectionInfo)
            val connectionInfo = initialConnectionInfo.copy(network = network)

            val preferences = PreferenceManager.getDefaultSharedPreferences(this)
            val connectionIds = preferences.getStringSet(LN_CONNECTION_IDS, mutableSetOf())!!
            if (!connectionIds.contains(currentConnectionId!!)) {
                connectionIds.add(currentConnectionId!!)
                preferences.edit()
                    .putStringSet(LN_CONNECTION_IDS, connectionIds)
                    .apply()
            }
            preferences.edit()
                .putLightningConnectionInfo(currentConnectionId!!, connectionInfo)
                .apply()
            setResult(requestCode, Intent().apply {
                putExtra(ActivityBase.LN_CONNECTION_INFO_EXTRA, connectionInfo)
            })
            finish()
        }
    }

    fun getNetworkFor(connectionInfo: LightningConnectionInfo) = runBlocking {
        val connection = createLightningStub(connectionInfo, this.coroutineContext)
        val nodeInfo = connection.getInfo(Rpc.GetInfoRequest.newBuilder().build())
        val chain = nodeInfo.chainsList.first()
        (connection.channel as ManagedChannel).shutdownNow()
        Network.byChainAndNetwork(chain.chain, chain.network)
    }

    override fun onCurrentConnectionIdChange(oldConnectionId: String?, newConnectionId: String) {}

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when (resultCode) {
            CERTIFICATE_RESULT -> {

            }
            MACAROON_RESULT -> File(data!!.data!!.path).readBytes()
        }
    }
    
    companion object {
        const val LN_CONNECTION_IDS = "ln_connection_ids"
        const val CERTIFICATE_RESULT = 0
        const val MACAROON_RESULT = 1
    }
}

fun SharedPreferences.Editor.putLightningConnectionInfo(id: String, connectionInfo: LightningConnectionInfo) =
    putString("ln_connection_${id}_host", connectionInfo.host)
        .putInt("ln_connection_${id}_port", connectionInfo.port)
        .putString("ln_connection_${id}_certificate", Base64.encodeToString(connectionInfo.certificate, Base64.DEFAULT))
        .putString("ln_connection_${id}_macaroon", Base64.encodeToString(connectionInfo.macaroon, Base64.DEFAULT))
        .putString("ln_connection_${id}_network_name", connectionInfo.network!!.name)
        .putString("ln_connection_${id}_name", connectionInfo.name)

fun SharedPreferences.getLightningConnectionInfo(id: String) = getString("ln_connection_${id}_host", null)?.let { host ->
    LightningConnectionInfo(
        connectionId = id,
        host = host,
        port = getInt("ln_connection_${id}_port", 0),
        certificate = Base64.decode(getString("ln_connection_${id}_certificate", null), Base64.DEFAULT),
        macaroon = Base64.decode(getString("ln_connection_${id}_macaroon", null), Base64.DEFAULT),
        network = Network.valueOf(getString("ln_connection_${id}_network_name", null) ?: throw RuntimeException("Missing config entry for network")),
        name = getString("ln_connection_${id}_name", null)
    )
}

