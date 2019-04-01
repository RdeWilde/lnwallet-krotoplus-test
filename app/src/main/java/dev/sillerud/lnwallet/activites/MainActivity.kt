package dev.sillerud.lnwallet.activites

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.preference.PreferenceManager
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.util.Base64
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.google.zxing.integration.android.IntentIntegrator
import dev.sillerud.lnwallet.LightningConnectionInfo
import dev.sillerud.lnwallet.R
import dev.sillerud.lnwallet.activites.settings.SettingsActivity
import dev.sillerud.lnwallet.activites.settings.WalletSettingsActivity
import dev.sillerud.lnwallet.activites.settings.getLightningConnectionInfo
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    val QR_SCAN = 1
    val WALLET_SETTINGS = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            IntentIntegrator(this)
                .setRequestCode(QR_SCAN)
                .initiateScan()
        }

        val toggle = ActionBarDrawerToggle(
            this, main_activity, toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        main_activity.addDrawerListener(toggle)
        toggle.syncState()

        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        sharedPreferences?.getStringSet("lnd_connection_ids", null)
            ?.map { sharedPreferences.getLightningConnectionInfo(it) }
            ?.forEach {  connectionInfo ->
                val item = navigationView.menu.add(R.id.walletList, Menu.NONE, 0, connectionInfo.name ?: connectionInfo.host)
                item.setOnMenuItemClickListener {
                    startActivity(Intent(this, WalletActivity::class.java)
                        .putExtra("lightning_connection_info", connectionInfo))
                    true
                }
            }
        navigationView.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (main_activity.isDrawerOpen(GravityCompat.START)) {
            main_activity.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.activity_main_drawer, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
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

            }
        }

        main_activity.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == QR_SCAN) {
            val intentResult = IntentIntegrator.parseActivityResult(resultCode, data)
            Log.d("qr-scan", "Got qr result ${intentResult.contents}")
            if (intentResult.contents.startsWith("lndconnect")) {
                val uri = Uri.parse(intentResult.contents)
                Log.i("qr-scan", "macaroon=${uri.getQueryParameter("macaroon")}")
                Log.i("qr-scan", "cert=${uri.getQueryParameter("cert")}")
                Log.i("qr-scan", "host=${uri.host}:${uri.port}")

                val macaroonBytes = Base64.decode(uri.getQueryParameter("macaroon"), Base64.URL_SAFE)
                val certBytes = Base64.decode(uri.getQueryParameter("cert"), Base64.URL_SAFE)
                val lightningConnectionInfo =
                    LightningConnectionInfo(uri.host!!, uri.port, macaroonBytes, certBytes, null)

                startActivity(Intent(this, WalletSettingsActivity::class.java).apply {
                    putExtra("lightning_connection_info", lightningConnectionInfo)
                    putExtra("requestCode", WALLET_SETTINGS)
                })
            } else {
                Toast.makeText(this, "Unhandled QR/barcode type", Toast.LENGTH_SHORT).show()
            }
        } else if (requestCode == WALLET_SETTINGS) {
            val lightningConnectionInfo = data!!.getParcelableExtra<LightningConnectionInfo>("lightning_connection_info")
            startActivity(Intent(this, WalletSettingsActivity::class.java).apply {
                putExtra("lightning_connection_info", lightningConnectionInfo)
            })
        }
    }
}