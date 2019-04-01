package dev.sillerud.lnwallet

data class WalletConfig(
    val macaroon: ByteArray,
    val cert: ByteArray
)