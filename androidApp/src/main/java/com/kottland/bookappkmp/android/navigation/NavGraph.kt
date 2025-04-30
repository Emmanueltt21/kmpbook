package com.kottland.bookappkmp.android.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.kottland.bookappkmp.android.ui.calculator.CalculatorScreen
import com.kottland.bookappkmp.android.ui.login.LoginScreen
import com.kottland.bookappkmp.android.ui.home.HomeScreen
import com.kottland.bookappkmp.android.ui.settings.SettingsScreen
import com.kottland.bookappkmp.android.ui.signup.SignUpScreen

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Login.route
    ) {
        composable(Screen.Login.route) {
            LoginScreen(navController)
        }
        composable(Screen.Signup.route) {
            SignUpScreen(navController)
        }
        composable(Screen.Home.route) {
            HomeScreen(navController)
        }
        composable(Screen.Settings.route) {
           // SettingsScreen(navController)
        }
        composable(Screen.Calculator.route) {
            CalculatorScreen(navController)
        }
    }
}
