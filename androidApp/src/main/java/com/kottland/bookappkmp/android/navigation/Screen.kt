package com.kottland.bookappkmp.android.navigation

sealed class Screen(val route: String) {
    object Login : Screen("login")
    object Signup : Screen("signup")
    object Home : Screen("home")
    object Settings : Screen("settings")
    object Calculator : Screen("calculator")

    // Bottom Tabs inside Home
    object HomeTab : Screen("home_tab")
    object CardsTab : Screen("cards_tab")
    object ProfileTab : Screen("profile_tab")
}
