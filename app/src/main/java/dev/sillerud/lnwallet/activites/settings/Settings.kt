package dev.sillerud.lnwallet.activites.settings

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.preference.*
import dev.sillerud.lnwallet.LocalCurrency
import dev.sillerud.lnwallet.R
import dev.sillerud.lnwallet.activites.ActivityBase
import java.util.*

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
    }
}

class SettingsFragment : PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        val context = preferenceManager.context
        val screen = preferenceManager.createPreferenceScreen(context)

        val walletCategory = PreferenceCategory(context).apply {
            key = "wallet_category"
            title = "Wallets"
        }
        screen.addPreference(walletCategory)

        preferenceManager.sharedPreferences.getStringSet(WalletSettingsActivity.LN_CONNECTION_IDS, mutableSetOf())?.forEach { connectionId ->
            val connectionInfo = preferenceManager.sharedPreferences.getLightningConnectionInfo(connectionId)!!
            walletCategory.addPreference(Preference(context).apply {
                key = connectionId
                title = "${connectionInfo.name} (${connectionInfo.network!!.displayName})"
                summary = "${connectionInfo.host}:${connectionInfo.port}"

                setOnPreferenceClickListener {
                    startActivityForResult(Intent(context, WalletSettingsActivity::class.java).apply {
                        putExtra(ActivityBase.LN_CONNECTION_INFO_EXTRA, connectionInfo)
                    }, 1)

                    true
                }
            })
        }

        walletCategory.addPreference(Preference(context).apply {
            key = "add_wallet"
            title = "Add wallet"
            summary = "Add a new lightning wallet"
            setOnPreferenceClickListener {
                startActivityForResult(Intent(context, WalletSettingsActivity::class.java).apply {
                    putExtra(ActivityBase.LN_CONNECTION_ID_EXTRA, UUID.randomUUID().toString())
                }, 1)

                true
            }
        })

        val applicationCategory = PreferenceCategory(context).apply {
            key = "application_category"
            title = "Application settings"
        }

        screen.addPreference(applicationCategory)

        applicationCategory.addPreference(ListPreference(context).apply {
            key = LOCAL_CURRENCY_PREFERENCE
            title = getString(R.string.settings_currency)
            summary = getString(R.string.settings_currency_summary)
            entries = LocalCurrency.values().map { it.name }.toTypedArray()
            entryValues = LocalCurrency.values().map { it.name }.toTypedArray()
            setValueIndex(entries.indexOf(LOCAL_CURRENCY_PREFERENCE_DEFAULT_VALUE))
        })

        preferenceScreen = screen
    }

    companion object {
        const val LOCAL_CURRENCY_PREFERENCE = "local_currency"
        val LOCAL_CURRENCY_PREFERENCE_DEFAULT_VALUE = LocalCurrency.EUR.name
    }
}