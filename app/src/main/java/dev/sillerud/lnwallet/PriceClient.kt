package dev.sillerud.lnwallet

import android.util.Log
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import com.squareup.okhttp.Callback
import com.squareup.okhttp.OkHttpClient
import com.squareup.okhttp.Request
import com.squareup.okhttp.Response
import java.io.IOException

fun wholeUnits(satoshi: Long) = 0.00000001*satoshi

val objectMapper: ObjectMapper = ObjectMapper().registerKotlinModule()

fun getPrice(crypto: String, currency: String): Price = OkHttpClient()
    .newCall(Request.Builder().url("https://api.coinbase.com/v2/prices/$crypto-$currency/buy").get().build())
    .execute()
    .body()
    .use { objectMapper.readValue(it.byteStream()) }

fun getPrice(crypto: String, currency: String, callback: (price: Price) -> Unit) {
    val httpClient = OkHttpClient()
    val call = Request.Builder()
        .url("https://api.coinbase.com/v2/prices/$crypto-$currency/buy")
        .get()
        .build()
    httpClient.newCall(call).enqueue(object : Callback {
        override fun onFailure(request: Request?, e: IOException?) {
            Log.e("price-client", "Failed to get response")
        }

        override fun onResponse(response: Response) {
            response.body().use {
                callback(ObjectMapper()
                    .registerKotlinModule()
                    .readValue(it.byteStream()))
            }
        }

    })
}

data class Price(
    val data: PriceData
)

data class PriceData(
    val base: String,
    val currency: String,
    val amount: String
)