package com.kottland.bookappkmp.android.data.repository

import com.kottland.bookappkmp.android.model.ExchangeRatesResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.json


class ExchangeRatesRepository {

    private val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json()
        }
    }

    suspend fun getExchangeRates(baseCurrency: String = "USD"): ExchangeRatesResponse {
        return client.get("https://api.exchangerate.host/latest?base=$baseCurrency").body()
    }
}
