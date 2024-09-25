package com.example.superheroapp.data.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.superheroapp.data.generateEnemies
import com.example.superheroapp.data.generateSuperheroes
import kotlinx.coroutines.flow.MutableStateFlow
import com.example.superheroapp.ui.screens.characters.uiState.CharacterUiState
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class CharactersViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(CharacterUiState())
    val uiState: StateFlow<CharacterUiState> = _uiState.asStateFlow()

    fun loadCharacters(isHero: Boolean) {
        viewModelScope.launch {
            _uiState.update {
                it.copy(
                    characterList = if (isHero) {
                        generateSuperheroes()
                    } else {
                        generateEnemies()
                    }
                )
            }
        }
    }
}