package dev.sillerud.lnwallet

import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import dev.sillerud.lnwallet.activites.ActivityBase
import dev.sillerud.lnwallet.activites.settings.SettingsFragment

class TransactionAdapter(
    private val transactions: List<TransactionDisplayInfo>,
    private val localCurrencyPrice: Double,
    private val activity: ActivityBase
) : RecyclerView.Adapter<TransactionAdapter.TransactionHolder>() {
    class TransactionHolder(val constraintLayout: ConstraintLayout) : RecyclerView.ViewHolder(constraintLayout)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.transaction, parent, false) as ConstraintLayout

        return TransactionHolder(view)
    }

    override fun getItemCount(): Int = transactions.size

    override fun onBindViewHolder(transactionHolder: TransactionHolder, index: Int) {
        val transaction = transactions[index]
        val transactionLayout = transactionHolder.constraintLayout
        val wholeCoins = wholeUnits(transaction.amount)

        val cryptoAmountFormat = activity.getString(R.string.crypto_currency_format)
        val localCurrencyFormat = activity.getString(R.string.local_currency_format)
        val cryptoCurrencyDisplayName = activity.getLaunchConnectionInfo()!!.network!!.displayName
        val localCurrency = activity.sharedPreferences.getString(
            SettingsFragment.LOCAL_CURRENCY_PREFERENCE,
            SettingsFragment.LOCAL_CURRENCY_PREFERENCE_DEFAULT_VALUE)!!

        transactionLayout.findViewById<TextView>(R.id.textAmount).text = String.format(cryptoAmountFormat, wholeCoins, cryptoCurrencyDisplayName)
        transactionLayout.findViewById<TextView>(R.id.textOtherPart).text = transaction.receivingNode

        // TODO: Don't run this on each transaction
        transactionLayout.findViewById<TextView>(R.id.textAmountLocalCurrency).text = localCurrencyFormat
            .format(localCurrencyPrice * wholeCoins, localCurrency)
    }
}