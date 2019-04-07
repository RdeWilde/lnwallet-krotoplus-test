package dev.sillerud.lnwallet

import java.util.*

data class TransactionDisplayInfo(
    val transactionDate: Date,
    val description: String?,
    val amount: Long,
    val receivingNode: String?
)