package com.kottland.bookappkmp.android.ui.home.tabs

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kottland.bookappkmp.android.R
import com.kottland.bookappkmp.android.model.Currency
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeTabViewModel : ViewModel() {

    // State
    private val _currencies = MutableStateFlow<List<Currency>>(emptyList())
    val currencies: StateFlow<List<Currency>> = _currencies.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    // Events
    fun loadCurrencies() {
        viewModelScope.launch {
            _isLoading.value = true
            // Simulate API call
            delay(2000)
            _currencies.value = getSampleCurrencies()
            _isLoading.value = false
        }
    }

    private fun getSampleCurrencies(): List<Currency> {
        return listOf(
            Currency("Naira", "NGN", R.drawable.baseline_currency_bitcoin_24),
            Currency("Rand", "ZAR", R.drawable.baseline_currency_bitcoin_24),
            Currency("CFA Franc", "XOF", R.drawable.baseline_currency_bitcoin_24),
        )
    }

}