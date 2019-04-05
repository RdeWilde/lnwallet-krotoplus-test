package dev.sillerud.lnwallet

enum class Network(val displayName: String, networkDisplayName: String, val bech32Prefix: String, val chain: String, val network: String) {
    LTC_MAINNET("LTC", "Litecoin mainnet", "ltc", "litecoin", "mainnet"),
    LTC_TESTNET("LTC", "Litecoin testnet", "ltcb", "litecoin", "testnet"),
    LTC_SIMNET("LTC", "Litecoin simnet", "ltcsn", "litecoin", "simnet"),
    BTC_MAINNET("BTC", "Bitcoin mainnet", "bc", "bitcoin", "mainnet"),
    BTC_TESTNET("BTC", "Bitcoin testnet", "bcb", "bitcoin", "testnet"),
    BTC_SIMNET("BTC", "Bitcoin simnet", "bcsn", "bitcoin", "simnet")
    ;

    companion object {
        fun byChainAndNetwork(chain: String, network: String) = Network.values()
            .find { it.chain == chain && it.network == network }
    }
}