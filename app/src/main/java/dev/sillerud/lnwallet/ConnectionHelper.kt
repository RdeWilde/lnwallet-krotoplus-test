package dev.sillerud.lnwallet

import com.github.marcoferrer.krotoplus.coroutines.withCoroutineContext
import io.grpc.okhttp.NegotiationType
import io.grpc.okhttp.OkHttpChannelBuilder
import lnrpc.LightningCoroutineGrpc
import javax.net.ssl.SSLContext
import kotlin.coroutines.CoroutineContext

fun createLightningStub(connectionInfo: LightningConnectionInfo, coroutineContext: CoroutineContext) : LightningCoroutineGrpc.LightningCoroutineStub {
    val sslContext = SSLContext.getInstance("TLS")
    sslContext.init(null, arrayOf(trustmanagerFor(connectionInfo.certificate)), null)

    val channel = OkHttpChannelBuilder.forAddress(connectionInfo.host, connectionInfo.port)
        .negotiationType(NegotiationType.TLS)
        .sslSocketFactory(sslContext.socketFactory)
        .build()
    return LightningCoroutineGrpc.newStub(channel)
        .withCallCredentials(MacaroonCredentials(connectionInfo.macaroon))
        .withCoroutineContext(coroutineContext)
}