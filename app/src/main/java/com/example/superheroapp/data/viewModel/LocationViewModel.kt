
package com.example.superheroapp.data.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.superheroapp.data.models.Location
import com.example.superheroapp.data.models.Superhero
import com.example.superheroapp.ui.screens.locationDetails.uiState.LocationUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LocationViewModel @Inject constructor(
    private val locations: List<Location>
) : ViewModel() {

    private val _uiState = MutableStateFlow(LocationUiState())
    val uiState: StateFlow<LocationUiState> = _uiState.asStateFlow()

    private lateinit var superhero: Superhero

    private fun loadLocations(): List<Location> {
        return locations.filter { location -> superhero.locations.contains(location.id) }
    }

    fun setSuperHero(superhero: Superhero) {
        if (uiState.value.superHero != superhero) {
            this.superhero = superhero
            viewModelScope.launch {
                val newUiState = _uiState.value.copy(
                    superHero = superhero,
                    locations = loadLocations()
                )
                _uiState.value = newUiState
            }
        }
    }
}