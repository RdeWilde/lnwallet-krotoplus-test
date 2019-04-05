package dev.sillerud.lnwallet.activites

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import dev.sillerud.lnwallet.R
import dev.sillerud.lnwallet.getPrice
import kotlinx.android.synthetic.main.activity_payment.*
import kotlinx.coroutines.*
import lnrpc.LightningCoroutineGrpc
import lnrpc.Rpc

class PaymentActivity : LightningAwareActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)
        initializeConnection()
    }

    override suspend fun onWalletChange(
        oldStub: LightningCoroutineGrpc.LightningCoroutineStub?,
        currentStub: LightningCoroutineGrpc.LightningCoroutineStub
    ) {
        buttonPayRequest.isEnabled = false

        val paymentRequest = intent.getStringExtra(PAYMENT_INFO_EXTRA)?.split(":")?.last()

        if (paymentRequest == null) {
            Log.w("payment-activity", "Unable to find payment info")
            Toast.makeText(this, "No payment requests were initiated.", Toast.LENGTH_SHORT).show()
            finish()
            return
        }

        // TODO: Fix so we can use async for loading
        val paymentInfo = currentStub.decodePayReq(Rpc.PayReqString.newBuilder().setPayReq(paymentRequest).build())
        val nodeInfo = currentStub.getNodeInfo(Rpc.NodeInfoRequest.newBuilder().setPubKey(paymentInfo.destination).build())
        val estimate: Long = try {
            currentStub.estimateFee(Rpc.EstimateFeeRequest.newBuilder().putAddrToAmount(paymentInfo.destination, paymentInfo.numSatoshis).build()).feeSat
        } catch (e: Exception) {
            Log.e("payment-activity", "Failed to get an fee estimate", e)
            0
        }
        val channelBalance = currentStub.channelBalance(Rpc.ChannelBalanceRequest.newBuilder().build())
        // TODO: Make this based on lightning node
        val alternativeCurrency = "NOK"
        getPrice("LTC", alternativeCurrency) { priceWrapper ->
            val price = priceWrapper.data
            runOnUiThread {
                textPriceTotal.text = "${textPriceTotal.text}\n (${price.amount.toDouble() * 0.00000001 * paymentInfo.numSatoshis} ${price.currency})"
            }
        }

        textPriceTotal.text = "Amount: ${paymentInfo.numSatoshis} litoshi"
        //\nestimated fee $estimate(broken)\n"
        textPaymentInfo.text = "Description: ${paymentInfo.description}"
        textReceivingNode.text = "Receiver: ${nodeInfo.node.alias}"// \nPublic key: ${paymentInfo.destination}"
        buttonPayRequest.text = when {
            channelBalance.balance < paymentInfo.numSatoshis + estimate -> getString(R.string.not_enough_available_funds)
            paymentInfo.expiry > System.currentTimeMillis() -> getString(R.string.expired)
            else -> {
                buttonPayRequest.isEnabled = true
                getString(R.string.complete_payment)
            }
        }
        buttonPayRequest.setOnClickListener {
            buttonPayRequest.text = getString(R.string.payment_in_progress)
            buttonPayRequest.isEnabled = false
            val paymentResponse = runBlocking {
                currentStub.sendPaymentSync(Rpc.SendRequest.newBuilder().setPaymentRequest(paymentRequest).build())
            }

            if (paymentResponse.paymentError.isNullOrEmpty()) {
                Toast.makeText(this, "Payment seems to be successful, hash: ${paymentResponse.paymentHash}", Toast.LENGTH_SHORT).show()
                Log.i("payment-activity", "Payment successful $paymentResponse")
                finish()
            } else {
                Log.w("payment-activity", "Failed to execute payment $paymentResponse")
                Toast.makeText(this, "An error occurred while executing payment ${paymentResponse.paymentError}", Toast.LENGTH_LONG).show()
            }
        }
    }

    companion object {
        const val PAYMENT_INFO_EXTRA = "payment_info"
    }
}