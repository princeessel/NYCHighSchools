package com.example.nychighschools.ui.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nychighschools.data.Client
import com.example.nychighschools.data.model.HighSchool
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    init {
        loadHighSchools()
    }

    private fun loadHighSchools() {
        viewModelScope.launch {
            val highSchools = Client.getService().getHighSchools()
            _uiState.value = UiState(
                highSchools = highSchools
            )
        }
    }

    fun selectHighSchool(highSchool: HighSchool) {
        _uiState.value = _uiState.value.copy(
            selectedSchool = highSchool
        )
    }

    data class UiState(
        val highSchools: List<HighSchool> = emptyList(),
        val selectedSchool: HighSchool? = null,
    )
}