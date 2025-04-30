package com.kottland.bookappkmp.android.ui.home

import androidx.lifecycle.ViewModel


import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeViewModel : ViewModel() {
    private val _selectedTab = MutableStateFlow(0)
    val selectedTab: StateFlow<Int> = _selectedTab.asStateFlow()

    fun onTabSelected(index: Int) {
        _selectedTab.value = index
    }
}