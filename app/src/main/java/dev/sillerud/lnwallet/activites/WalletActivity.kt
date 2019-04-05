package dev.sillerud.lnwallet.activites

import android.os.Bundle
import android.util.Log
import dev.sillerud.lnwallet.*
import dev.sillerud.lnwallet.activites.settings.SettingsFragment
import dev.sillerud.lnwallet.activites.settings.getLightningConnectionInfo
import kotlinx.android.synthetic.main.activity_wallet.*
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
        val connectionInfo = sharedPreferences.getLightningConnectionInfo(currentConnectionId!!)
        val localCurrency = sharedPreferences.getString(SettingsFragment.LOCAL_CURRENCY_PREFERENCE,
            SettingsFragment.LOCAL_CURRENCY_PREFERENCE_DEFAULT_VALUE)
        val balance = currentStub.channelBalance(Rpc.ChannelBalanceRequest.newBuilder().build())
        val walletBalance = currentStub.walletBalance(Rpc.WalletBalanceRequest.newBuilder().build())
        balanceText.text = "Channel balance: ${balance.balance} litoshi"
        walletBalanceText.text = "Wallet balance: ${walletBalance.confirmedBalance} litoshi"
        // TODO: Implement getting currency from settings and crypto from ln node
        getPrice(connectionInfo.network!!.displayName, localCurrency) { priceWrapper ->
            val price = priceWrapper.data
            runOnUiThread {
                balanceText.text = "${balanceText.text}\n (${price.amount.toDouble() * 0.00000001 * balance.balance} ${price.currency})"
                walletBalanceText.text = "${walletBalanceText.text}\n (${price.amount.toDouble() * 0.00000001 * walletBalance.confirmedBalance} ${price.currency})"
            }
        }
        Log.i("wallet-activity", currentStub.channelBalance(Rpc.ChannelBalanceRequest.newBuilder().build()).balance.toString())
    }
}
