package com.kottland.bookappkmp.android.ui.home.tabs

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kottland.bookappkmp.android.model.Currency

@Composable
 fun HomeTab(
    modifier: Modifier = Modifier,
    viewModel: HomeTabViewModel = viewModel() // ← This creates/hooks the ViewModel
 ) {
    val currencies by viewModel.currencies.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()


    Column(modifier = modifier) {
        if (isLoading) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        } else {
            LazyColumn {
                items(currencies) { currency ->
                    CurrencyItem(currency)
                }
            }
        }
    }

    LaunchedEffect(Unit) {
        viewModel.loadCurrencies()
    }
}


@Composable
fun CurrencyItem(currency: Currency) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = currency.flagRes),
            contentDescription = "${currency.name} flag",
            modifier = Modifier.size(48.dp)
        )
        Spacer(Modifier.width(16.dp))
        Text(
            text = "${currency.name} (${currency.code})",
            style = MaterialTheme.typography.titleMedium
        )
    }
}