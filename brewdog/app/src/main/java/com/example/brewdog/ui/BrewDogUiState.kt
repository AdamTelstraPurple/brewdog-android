package com.example.brewdog.ui

import org.json.JSONObject

data class BrewDogUiState(
    val beerList: JSONObject = JSONObject()
)