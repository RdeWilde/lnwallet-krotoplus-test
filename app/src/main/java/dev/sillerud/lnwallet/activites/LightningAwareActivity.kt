package dev.sillerud.lnwallet.activites

import android.util.Log
import dev.sillerud.lnwallet.*
import dev.sillerud.lnwallet.activites.settings.getLightningConnectionInfo
import io.grpc.ManagedChannel
import kotlinx.coroutines.runBlocking
import lnrpc.LightningCoroutineGrpc
abstract class LightningAwareActivity : ActivityBase() {
    var lightningStub: LightningCoroutineGrpc.LightningCoroutineStub? = null
        set(value) {
            val old = field
            field = value
            runBlocking { onWalletChange(old, value!!) }
            closeChannel(old)
        }

    fun initializeConnection() {
        val connectionInfo = getLaunchConnectionInfo()

        if (connectionInfo != null) {
            lightningStub = createLightningStub(connectionInfo, coroutineContext)
            Log.i("ln-aware", "Connection created to ${connectionInfo.host}:${connectionInfo.port}")
        }
    }

    override fun onCurrentConnectionIdChange(oldConnectionId: String?, newConnectionId: String) {
        lightningStub = sharedPreferences.getLightningConnectionInfo(newConnectionId)?.let { connectionInfo ->
            createLightningStub(connectionInfo, coroutineContext)
        }
    }

    private fun closeChannel(stub: LightningCoroutineGrpc.LightningCoroutineStub?) {
        stub?.channel?.let {
            if (it is ManagedChannel) {
                it.shutdownNow()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        closeChannel(lightningStub)
    }

    abstract suspend fun onWalletChange(
        oldStub: LightningCoroutineGrpc.LightningCoroutineStub?,
        currentStub: LightningCoroutineGrpc.LightningCoroutineStub
    )
}