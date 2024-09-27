package com.example.superheroapp.data.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.superheroapp.data.generateLocations
import com.example.superheroapp.data.models.Location
import com.example.superheroapp.data.models.Superhero
import com.example.superheroapp.ui.screens.locationDetails.uiState.LocationUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LocationViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(LocationUiState())
    val uiState : StateFlow<LocationUiState> =_uiState.asStateFlow()

    private lateinit var superhero: Superhero

    private fun loadLocations(locations: List<Location>): List<Location>{
        val realLocations = locations.filter {
            location -> superhero.locations.contains(location.id)
        }
        return realLocations
    }

    fun setSuperHero(superhero: Superhero){
        if(uiState.value.superHero != superhero){
            this.superhero = superhero
            viewModelScope.launch {
                val newUiState = _uiState.value.copy(
                    superHero = superhero,
                    locations = loadLocations(generateLocations())
                )
                _uiState.value = newUiState
            }
        }
    }

}