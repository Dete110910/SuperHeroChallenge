package com.example.superheroapp.data.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.superheroapp.data.generatePowers
import com.example.superheroapp.data.models.Power
import com.example.superheroapp.data.models.Superhero
import com.example.superheroapp.ui.screens.locationDetails.uiState.LocationUiState
import com.example.superheroapp.ui.screens.powerDetails.uiState.PowerUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PowerViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(PowerUiState())
    val uiState : StateFlow<PowerUiState> =_uiState.asStateFlow()

    private lateinit var superhero: Superhero

    private fun loadPowers(powers: List<Power>): List<Power>{
        val realPowers = powers.filter {
            power -> superhero.powers.contains(power.id)
        }
        return realPowers

    }

    fun setSuperHero(superhero: Superhero){
        if(uiState.value.superHero != superhero){
            this.superhero = superhero
            viewModelScope.launch {
                val newUiState = _uiState.value.copy(
                    superHero = superhero,
                    powers = loadPowers(generatePowers())
                )
                _uiState.value = newUiState
            }
        }
    }
}