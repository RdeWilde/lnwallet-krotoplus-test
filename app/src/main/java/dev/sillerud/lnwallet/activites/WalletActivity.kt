package dev.sillerud.lnwallet.activites

import android.os.Bundle
import android.util.Log
import dev.sillerud.lnwallet.*
import kotlinx.android.synthetic.main.activity_wallet.*
import kotlinx.coroutines.runBlocking
import lnrpc.LightningCoroutineGrpc
import lnrpc.Rpc

class WalletActivity : LightningAwareActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wallet)
        initializeConnection()
    }

    override suspend fun onWalletChange(
        oldStub: LightningCoroutineGrpc.LightningCoroutineStub?,
        currentStub: LightningCoroutineGrpc.LightningCoroutineStub
    ) {
        val balance = currentStub.channelBalance(Rpc.ChannelBalanceRequest.newBuilder().build())
        val walletBalance = currentStub.walletBalance(Rpc.WalletBalanceRequest.newBuilder().build())
        balanceText.text = "Channel balance: ${balance.balance} litoshi"
        walletBalanceText.text = "Wallet balance: ${walletBalance.confirmedBalance} litoshi"
        // TODO: Implement getting currency from settings and crypto from ln node
        getPrice("LTC", "NOK") { priceWrapper ->
            val price = priceWrapper.data
            runOnUiThread {
                balanceText.text = "${balanceText.text}\n (${price.amount.toDouble() * 0.00000001 * balance.balance} ${price.currency})"
                walletBalanceText.text = "${walletBalanceText.text}\n (${price.amount.toDouble() * 0.00000001 * walletBalance.confirmedBalance} ${price.currency})"
            }
        }
        Log.i("wallet-activity", currentStub.channelBalance(Rpc.ChannelBalanceRequest.newBuilder().build()).balance.toString())
    }
}
