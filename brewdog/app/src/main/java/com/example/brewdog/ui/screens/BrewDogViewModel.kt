package com.example.brewdog.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.brewdog.netowrk.BrewDogApi
import com.example.brewdog.ui.BrewDogUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch





class BrewDogViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(BrewDogUiState())
    val uiState: StateFlow<BrewDogUiState> = _uiState.asStateFlow()
    init {
        getBeers()
    }
    private fun getBeers(){
        viewModelScope.launch {
            val result = BrewDogApi.retrofitService.getBeers("1")
            _uiState.value = BrewDogUiState(beerList = result)
        }
    }
}