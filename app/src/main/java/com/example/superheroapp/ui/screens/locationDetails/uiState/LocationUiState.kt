package com.example.superheroapp.ui.screens.locationDetails.uiState

import com.example.superheroapp.data.models.Location
import com.example.superheroapp.data.models.Superhero

data class LocationUiState(
    val superHero: Superhero? = null,
    val locations: List<Location> = emptyList()
)