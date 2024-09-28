package com.example.superheroapp.ui.screens.powerDetails.uiState

import com.example.superheroapp.data.models.Power
import com.example.superheroapp.data.models.Superhero

data class PowerUiState(
    val superHero: Superhero? = null,
    val powers: List<Power> = emptyList()
)