package com.kottland.bookappkmp.android.ui.calculator

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.provider.FontsContractCompat.Columns
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@Composable
fun  CalculatorScreen (
    navController: NavController,
    viewModel: CalculatorViewModel = viewModel()
        ){



    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Calculator ",
            style = MaterialTheme.typography.headlineMedium
        )
    }

        }