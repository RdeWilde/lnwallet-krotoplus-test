package dev.sillerud.lnwallet.activites

import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceManager
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import dev.sillerud.lnwallet.*
import dev.sillerud.lnwallet.activites.settings.SettingsActivity
import dev.sillerud.lnwallet.activites.settings.SettingsFragment
import dev.sillerud.lnwallet.activites.settings.WalletSettingsActivity
import dev.sillerud.lnwallet.activites.settings.getLightningConnectionInfo
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import lnrpc.LightningCoroutineGrpc
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : LightningAwareActivity(), NavigationView.OnNavigationItemSelectedListener {
    val dateFormat = SimpleDateFormat.getDateInstance()
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

        updateWalletList()
        navigationView.setNavigationItemSelectedListener(this)

        val localCurrency = sharedPreferences.getString(SettingsFragment.LOCAL_CURRENCY_PREFERENCE,
            SettingsFragment.LOCAL_CURRENCY_PREFERENCE_DEFAULT_VALUE)

        textCryptoBalance.text = getString(R.string.empty_balance)
        textLocalBalance.text = getString(R.string.local_currency_format).format(0.0, localCurrency)
    }

    override fun onResume() {
        super.onResume()
        updateWalletList()
        initializeConnection()
    }

    fun updateWalletList() {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        val subMenu = navigationView.menu.items().first { it.itemId == R.id.wallet_list }.subMenu
        subMenu.clear()

        sharedPreferences?.getStringSet(WalletSettingsActivity.LN_CONNECTION_IDS, null)
            ?.map { it to sharedPreferences.getLightningConnectionInfo(it)!! }
            ?.forEach {  (connectionId, connectionInfo) ->
                val item = subMenu.add(R.id.wallet_list_group, Menu.NONE, 0, connectionInfo.name ?: connectionInfo.host)
                item.setOnMenuItemClickListener {
                    currentConnectionId = connectionId
                    main_activity.closeDrawer(GravityCompat.START)
                    true
                }
            }
    }

    fun Menu.items() = 0.until(size()).map { getItem(it) }

    override suspend fun onWalletChange(
        oldStub: LightningCoroutineGrpc.LightningCoroutineStub?,
        currentStub: LightningCoroutineGrpc.LightningCoroutineStub
    ) {
        val localCurrency = sharedPreferences.getString(SettingsFragment.LOCAL_CURRENCY_PREFERENCE,
            SettingsFragment.LOCAL_CURRENCY_PREFERENCE_DEFAULT_VALUE)!!
        val connectionInfo = sharedPreferences.getLightningConnectionInfo(currentConnectionId!!)!!

        runBlocking {
            val channelBalanceDeferred = async(Dispatchers.IO) { currentStub.channelBalance() }
            val networkInfoDeferred = async(Dispatchers.IO) { currentStub.describeGraph() }
            val paymentsDeferred = async(Dispatchers.IO) { currentStub.listPayments() }
            val priceDeferred = async(Dispatchers.IO) { getPrice(connectionInfo.network!!.displayName, localCurrency) }

            /*val transactions = currentStub.getTransactions(Rpc.GetTransactionsRequest.newBuilder().build())
            transactions.transactionsList.forEach {
                Log.d("wallet-activity", it.toString())
            }*/

            val combinedBalance = channelBalanceDeferred.await().balance
            textCryptoBalance.text = connectionInfo.network!!.balanceFormat(combinedBalance)

            val transactions = paymentsDeferred.await().paymentsList.mapNotNull { payment ->
                Log.d("wallet-activity", payment.toString())
                val receivingNode = networkInfoDeferred.await().nodesList
                    .find { node -> node.pubKey == payment.pathList.last() }

                TransactionDisplayInfo(
                    transactionDate = Date(payment.creationDate * 1000),
                    description = null,
                    amount = payment.value,
                    receivingNode = receivingNode?.alias
                )
            }.sortedByDescending { it.transactionDate }
            //.groupBy { dateFormat.format(it.transactionDate) }

            val localCurrencyPrice = priceDeferred.await().data.amount.toDouble()
            transaction_list.apply {
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(this@MainActivity)
                adapter = TransactionAdapter(transactions, localCurrencyPrice, this@MainActivity)
            }
            val wholeCoins = wholeUnits(combinedBalance)
            textLocalBalance.text = getString(R.string.local_currency_format)
                .format(localCurrencyPrice * wholeCoins, localCurrency)
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
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.action_settings -> run {
            startActivity(Intent(this, WalletSettingsActivity::class.java))
            true
        }
        else -> super.onOptionsItemSelected(item)
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