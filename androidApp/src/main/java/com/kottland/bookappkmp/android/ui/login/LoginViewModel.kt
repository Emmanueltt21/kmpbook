package com.kottland.bookappkmp.android.ui.login


import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import kotlinx.coroutines.launch
import kotlinx.coroutines.delay

data class LoginUiState(
    val email: String = "",
    val password: String = "",
    val rememberMe: Boolean = false,
    val isPasswordVisible: Boolean = false,
    val isLoading: Boolean = false // Added loading state
)

class LoginViewModel : ViewModel() {


    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState

    fun onEmailChanged(newEmail: String) {
        _uiState.update { it.copy(email = newEmail) }
    }

    fun onPasswordChanged(newPassword: String) {
        _uiState.update { it.copy(password = newPassword) }
    }

    fun onRememberMeToggled(checked: Boolean) {
        _uiState.update { it.copy(rememberMe = checked) }
    }

    fun onPasswordVisibilityToggled() {
        _uiState.update { it.copy(isPasswordVisible = !it.isPasswordVisible) }
    }


    fun onLoginClicked(navController: NavController) {
        viewModelScope.launch {
            // Show loading
            _uiState.value = _uiState.value.copy(isLoading = true)

            // Simulate API call
            delay(3000)

            // Hide loading
            _uiState.value = _uiState.value.copy(isLoading = false)

            // Navigate to home
            navController.navigate("home") {
              //  popUpTo("login") { inclusive = true }
             //   popUpTo("login") { inclusive = true }
            }
        }
    }



  /*  fun onLoginClicked() {
        val currentState = _uiState.value
        // TODO: Implement your authentication logic here (e.g., call API or validate locally)
        println("Trying to login with email: ${currentState.email} and password: ${currentState.password}")
    }*/
}
