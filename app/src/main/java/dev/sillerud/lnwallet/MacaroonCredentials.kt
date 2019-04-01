package dev.sillerud.lnwallet

import io.grpc.Attributes
import io.grpc.CallCredentials
import io.grpc.Metadata
import io.grpc.MethodDescriptor
import java.util.concurrent.Executor

class MacaroonCredentials(macaroon: ByteArray) : CallCredentials {
    private val macaroonKey: Metadata.Key<String> = Metadata.Key.of("macaroon", Metadata.ASCII_STRING_MARSHALLER)
    private val macaroonHex = macaroon.asUByteArray().joinToString("") {
        it.toString(16).padStart(2, '0')
    }
    override fun applyRequestMetadata(
        method: MethodDescriptor<*, *>,
        attrs: Attributes,
        executor: Executor,
        applier: CallCredentials.MetadataApplier
    ) {
        executor.execute {
            applier.apply(Metadata().apply {
                put(macaroonKey, macaroonHex)
            })
        }
    }

    override fun thisUsesUnstableApi() {}
}