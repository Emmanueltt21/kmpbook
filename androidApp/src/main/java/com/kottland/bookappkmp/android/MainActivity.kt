package com.kottland.bookappkmp.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.kottland.bookappkmp.android.navigation.Screen
import com.kottland.bookappkmp.android.ui.calculator.CalculatorScreen
import com.kottland.bookappkmp.android.ui.home.HomeScreen
import com.kottland.bookappkmp.android.ui.login.LoginScreen
import com.kottland.bookappkmp.android.ui.signup.SignUpScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                val navController = rememberNavController()

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavHost(navController = navController, startDestination = Screen.Login.route) {

                        composable(Screen.Login.route) {
                            LoginScreen(navController)
                        }

                        composable(Screen.Signup.route) {
                            SignUpScreen(navController)
                        }

                        composable(Screen.Home.route) {
                           HomeScreen(navController)
                        }
                        composable(Screen.Calculator.route) {
                           CalculatorScreen(navController)
                        }

                        composable(Screen.Settings.route) {
                          //  SettingsScreen(navController)
                        }
                    }
                }
            }
        }
    }
}



