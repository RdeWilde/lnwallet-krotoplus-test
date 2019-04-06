package dev.sillerud.lnwallet.activites

import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import android.preference.PreferenceManager
import android.support.v7.app.AppCompatActivity
import android.util.Base64
import android.util.Log
import android.widget.Toast
import com.google.zxing.integration.android.IntentIntegrator
import dev.sillerud.lnwallet.LN_CURRENT_CONNECTION_ID
import dev.sillerud.lnwallet.LightningConnectionInfo
import dev.sillerud.lnwallet.activites.settings.WalletSettingsActivity
import dev.sillerud.lnwallet.activites.settings.getLightningConnectionInfo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import java.util.*
import kotlin.coroutines.CoroutineContext

abstract class ActivityBase : AppCompatActivity(), CoroutineScope {
    private val job = Job()
    override val coroutineContext: CoroutineContext = Dispatchers.Main + job

    lateinit var sharedPreferences: SharedPreferences

    var currentConnectionId: String? = null
        set(value) {
            val old = field
            field = value ?: return
            sharedPreferences.edit().putString(LN_CURRENT_CONNECTION_ID, value).apply()
            if (old != null) {
                onCurrentConnectionIdChange(old, value)
            }
        }

    abstract fun onCurrentConnectionIdChange(oldConnectionId: String?, newConnectionId: String)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)

        currentConnectionId = intent.getStringExtra(LN_CONNECTION_ID_EXTRA)
            ?: sharedPreferences.getString(LN_CURRENT_CONNECTION_ID, null)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == QR_SCAN) {
            val intentResult = IntentIntegrator.parseActivityResult(resultCode, data)
            Log.d("qr-scan", "Got qr result ${intentResult.contents}")
            when {
                intentResult.contents.startsWith("lndconnect") -> {
                    val uri = Uri.parse(intentResult.contents)
                    handleLndConnectUri(uri)
                }
                intentResult.contents.matches(PaymentActivity.PAYMENT_URI_REGEXP) -> {
                    Log.i("qr-scan", "Found payment qr code, creating payment intent")
                    startActivityForResult(Intent(this, PaymentActivity::class.java).apply {
                        putExtra(PaymentActivity.PAYMENT_INFO_EXTRA, intentResult.contents)
                    }, 1337) // TODO
                }
                else -> Toast.makeText(this, "Unhandled QR/barcode type", Toast.LENGTH_SHORT).show()
            }
        } else if (requestCode == WALLET_SETTINGS) {
            val lightningConnectionInfo = data!!.getParcelableExtra<LightningConnectionInfo>(LN_CONNECTION_INFO_EXTRA)
            startActivity(Intent(this, WalletSettingsActivity::class.java).apply {
                putExtra(LN_CONNECTION_INFO_EXTRA, lightningConnectionInfo)
            })
        }
    }

    fun handleLndConnectUri(uri: Uri) {
        Log.i("qr-scan", "Handling QR scan uri $uri")

        val macaroonBytes = Base64.decode(uri.getQueryParameter("macaroon"), Base64.URL_SAFE)
        val certBytes = Base64.decode(uri.getQueryParameter("cert"), Base64.URL_SAFE)
        val lightningConnectionInfo = LightningConnectionInfo(
            connectionId = UUID.randomUUID().toString(),
            host = uri.host!!,
            port = uri.port,
            macaroon = macaroonBytes,
            certificate = certBytes,
            network = null,
            name = null
        )
        Log.i("qr-scan", "Parsed uri result $lightningConnectionInfo")


        startActivity(Intent(this, WalletSettingsActivity::class.java).apply {
            putExtra(LN_CONNECTION_INFO_EXTRA, lightningConnectionInfo)
            putExtra("requestCode", WALLET_SETTINGS)
        })
    }

    fun getLaunchConnectionInfo(): LightningConnectionInfo? =
        intent.getParcelableExtra(LN_CONNECTION_INFO_EXTRA)
            ?: currentConnectionId?.let { id -> sharedPreferences.getLightningConnectionInfo(id) }

    fun initQrScan() {
        IntentIntegrator(this)
            .setRequestCode(QR_SCAN)
            .initiateScan()
    }

    companion object {
        const val QR_SCAN = 1
        const val WALLET_SETTINGS = 2

        const val LN_CONNECTION_ID_EXTRA = "ln_connection_id_extra"
        const val LN_CONNECTION_INFO_EXTRA = "ln_connection_info_extra"
    }
}