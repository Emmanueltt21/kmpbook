package com.kottland.bookappkmp.android.ui.home.tabs

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class  ProfileViewModel : ViewModel(){

 private val _isDarkMode = mutableStateOf(false)
 val isDarkMode: State<Boolean> = _isDarkMode

 fun toggleTheme() {
  _isDarkMode.value = !_isDarkMode.value
  // Save preference using DataStore or SharedPreferences
 }



 }