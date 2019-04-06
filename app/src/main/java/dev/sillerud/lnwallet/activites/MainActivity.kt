package dev.sillerud.lnwallet.activites

import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceManager
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.Menu
import android.view.MenuItem
import dev.sillerud.lnwallet.R
import dev.sillerud.lnwallet.activites.settings.SettingsActivity
import dev.sillerud.lnwallet.activites.settings.SettingsFragment
import dev.sillerud.lnwallet.activites.settings.WalletSettingsActivity
import dev.sillerud.lnwallet.activites.settings.getLightningConnectionInfo
import dev.sillerud.lnwallet.getPrice
import dev.sillerud.lnwallet.wholeUnits
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.coroutines.launch
import lnrpc.LightningCoroutineGrpc
import lnrpc.Rpc

class MainActivity : LightningAwareActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            initQrScan()
        }

        val toggle = ActionBarDrawerToggle(
            this, main_activity, toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        main_activity.addDrawerListener(toggle)
        toggle.syncState()

        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        sharedPreferences?.getStringSet(WalletSettingsActivity.LN_CONNECTION_IDS, null)
            ?.map { it to sharedPreferences.getLightningConnectionInfo(it) }
            ?.forEach {  (connectionId, connectionInfo) ->
                val item = navigationView.menu.add(R.id.walletList, Menu.NONE, 0, connectionInfo.name ?: connectionInfo.host)
                item.setOnMenuItemClickListener {
                    currentConnectionId = connectionId
                    startActivity(Intent(this, WalletActivity::class.java)
                        .putExtra(LN_CONNECTION_INFO_EXTRA, connectionInfo))
                    true
                }
            }
        navigationView.setNavigationItemSelectedListener(this)

        val localCurrency = sharedPreferences.getString(SettingsFragment.LOCAL_CURRENCY_PREFERENCE,
            SettingsFragment.LOCAL_CURRENCY_PREFERENCE_DEFAULT_VALUE)

        textCryptoBalance.text = getString(R.string.empty_balance)
        textLocalBalance.text = getString(R.string.local_currency_format).format(0.0, localCurrency)

        initializeConnection()
    }

    override fun onResume() {
        super.onResume()
        initializeConnection()
    }

    override suspend fun onWalletChange(
        oldStub: LightningCoroutineGrpc.LightningCoroutineStub?,
        currentStub: LightningCoroutineGrpc.LightningCoroutineStub
    ) {
        val localCurrency = sharedPreferences.getString(SettingsFragment.LOCAL_CURRENCY_PREFERENCE,
            SettingsFragment.LOCAL_CURRENCY_PREFERENCE_DEFAULT_VALUE)!!
        val connectionInfo = sharedPreferences.getLightningConnectionInfo(currentConnectionId!!)

        val channelBalance = currentStub.channelBalance(Rpc.ChannelBalanceRequest.newBuilder().build())

        val combinedBalance = channelBalance.balance
        val wholeCoins = wholeUnits(combinedBalance)

        textCryptoBalance.text = connectionInfo.network!!.balanceFormat(combinedBalance)
        getPrice(connectionInfo.network.displayName, localCurrency) {
            launch {
                textLocalBalance.text = getString(R.string.local_currency_format).format(it.data.amount.toDouble() * wholeCoins, localCurrency)
            }
        }
    }

    override fun onBackPressed() {
        if (main_activity.isDrawerOpen(GravityCompat.START)) {
            main_activity.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.activity_main_drawer, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_settings -> {
                startActivity(Intent(this, SettingsActivity::class.java))
            }
            R.id.nav_qr_scan -> {
                initQrScan()
            }
        }

        main_activity.closeDrawer(GravityCompat.START)
        return true
    }
}