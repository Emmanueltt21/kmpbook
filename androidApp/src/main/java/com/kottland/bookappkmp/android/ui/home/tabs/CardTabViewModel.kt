package com.kottland.bookappkmp.android.ui.home.tabs
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kottland.bookappkmp.android.model.ExchangeRatesResponse
import com.kottland.bookappkmp.android.data.repository.ExchangeRatesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CardTabViewModel : ViewModel() {

    private val repository = ExchangeRatesRepository()

    private val _exchangeRates = MutableStateFlow<Map<String, Double>>(emptyMap())
    val exchangeRates: StateFlow<Map<String, Double>> = _exchangeRates.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    init {
        loadExchangeRates()
    }

    fun loadExchangeRates(base: String = "USD") {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val response = repository.getExchangeRates(base)
                _exchangeRates.value = response.rates
            } catch (e: Exception) {
                // Handle the error gracefully (optional: you can show an error state or log it)
                Log.e("CardTabViewModel", "Error: ${e.message}", e)
                //Toast.makeText(context, e.localizedMessage ?: "An error occurred", Toast.LENGTH_SHORT).show()
                e.printStackTrace()
                // Optionally clear exchange rates or keep old values
                _exchangeRates.value = emptyMap()
            } finally {
                _isLoading.value = false
            }
        }
    }
}
