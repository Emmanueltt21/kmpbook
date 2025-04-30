package com.kottland.bookappkmp.android.ui.home.tabs

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.kottland.bookappkmp.android.navigation.Screen
import com.kottland.bookappkmp.android.ui.home.HomeViewModel
import androidx.compose.foundation.rememberScrollState


@Composable
fun ProfileTab(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: ProfileViewModel = viewModel()
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
       // Text("Profile", style = MaterialTheme.typography.headlineMedium)

       // Spacer(Modifier.height(16.dp))

        ProfileSection("Manage") {
            ProfileOption("Manage Users") { /* Navigate or handle */ }
            ProfileOption("Manage Clients") { /* Navigate or handle */ }
        }

        ProfileSection("Settings") {
            ProfileOption("Transaction History") { }
            ProfileOption("Languages") { }
            ProfileOption("Permission") { }
            ProfileOption("Theme") {
                // Toggle theme
                viewModel.toggleTheme()
            }
        }

        ProfileSection("Security") {
            ProfileOption("Blocked Account") { }
        }

        ProfileSection("Others") {
            ProfileOption("About Wallet") { }
        }

        Spacer(modifier = Modifier.weight(1f))
        Spacer(Modifier.height(16.dp))

        Button(
            onClick = { /* Logout logic */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(Icons.Default.ExitToApp, contentDescription = "Logout")
            Spacer(modifier = Modifier.width(8.dp))
            Text("Log Out", color = Color.White)
        }
    }
}

@Composable
fun ProfileSection(title: String, content: @Composable ColumnScope.() -> Unit) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            title,
            style = MaterialTheme.typography.titleSmall,
            modifier = Modifier.padding(vertical = 8.dp)
        )
        content()
    }
}

@Composable
fun ProfileOption(text: String, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text, style = MaterialTheme.typography.bodyLarge)
        Icon(Icons.Default.KeyboardArrowRight, contentDescription = null)
    }
}
