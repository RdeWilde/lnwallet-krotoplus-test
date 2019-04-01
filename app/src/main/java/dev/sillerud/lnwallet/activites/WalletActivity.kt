package dev.sillerud.lnwallet.activites

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.github.marcoferrer.krotoplus.coroutines.withCoroutineContext
import dev.sillerud.lnwallet.LightningConnectionInfo
import dev.sillerud.lnwallet.MacaroonCredentials
import dev.sillerud.lnwallet.R
import dev.sillerud.lnwallet.trustmanagerFor
import io.grpc.okhttp.NegotiationType
import io.grpc.okhttp.OkHttpChannelBuilder
import kotlinx.android.synthetic.main.activity_wallet.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.runBlocking
import lnrpc.LightningCoroutineGrpc
import lnrpc.Rpc
import javax.net.ssl.SSLContext

class WalletActivity : AppCompatActivity() {
    private val job = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + job)
    private lateinit var stub: LightningCoroutineGrpc.LightningCoroutineStub
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val connectionInfo = intent.getParcelableExtra<LightningConnectionInfo>("lightning_connection_info")
        Log.d("wallet-activity", connectionInfo.toString())
        setContentView(R.layout.activity_wallet)

        val sslContext = SSLContext.getInstance("TLS")
        sslContext.init(null, arrayOf(trustmanagerFor(connectionInfo.certificate)), null)

        val channel = OkHttpChannelBuilder.forAddress(connectionInfo.host, connectionInfo.port)
            .negotiationType(NegotiationType.TLS)
            .sslSocketFactory(sslContext.socketFactory)
            .build()
        stub = LightningCoroutineGrpc.newStub(channel)
            .withCallCredentials(MacaroonCredentials(connectionInfo.macaroon))
            .withCoroutineContext(uiScope.coroutineContext)

        val balance = runBlocking { stub.channelBalance(Rpc.ChannelBalanceRequest.newBuilder().build()) }
        balanceText.text = "${balance.balance} litoshi(s)"
        runBlocking {
            Log.i("wallet-activity", stub.channelBalance(Rpc.ChannelBalanceRequest.newBuilder().build()).balance.toString())
        }
    }

}
