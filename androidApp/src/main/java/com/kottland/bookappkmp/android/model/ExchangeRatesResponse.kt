package com.kottland.bookappkmp.android.model

import kotlinx.serialization.Serializable


@Serializable
data class ExchangeRatesResponse(
    val base: String,
    val date: String,
    val rates: Map<String, Double>
)
