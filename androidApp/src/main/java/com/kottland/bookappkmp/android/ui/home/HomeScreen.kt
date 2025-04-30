package com.kottland.bookappkmp.android.ui.home


import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kottland.bookappkmp.android.ui.home.tabs.CardsTab
import com.kottland.bookappkmp.android.ui.home.tabs.HomeTab
import com.kottland.bookappkmp.android.ui.home.tabs.ProfileTab


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = viewModel()
) {
    val selectedTab by viewModel.selectedTab.collectAsState()

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Book App", style = MaterialTheme.typography.headlineSmall) },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        },
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    icon = { Icon(Icons.Filled.Home, contentDescription = "Home") },
                    label = { Text("Home") },
                    selected = selectedTab == 0,
                    onClick = { viewModel.onTabSelected(0) }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Filled.Favorite, contentDescription = "Cards") },
                    label = { Text("Cards") },
                    selected = selectedTab == 1,
                    onClick = { viewModel.onTabSelected(1) }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Filled.Person, contentDescription = "Profile") },
                    label = { Text("Profile") },
                    selected = selectedTab == 2,
                    onClick = { viewModel.onTabSelected(2) }
                )
            }
        }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            when (selectedTab) {
                0 -> HomeTab(Modifier.fillMaxSize())
                1 -> CardsTab(Modifier.fillMaxSize())
                2 -> ProfileTab(navController, Modifier.fillMaxSize())
            }
        }
    }
}



