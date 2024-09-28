
package com.example.superheroapp.data.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.superheroapp.data.models.Enemy
import com.example.superheroapp.data.models.Superhero
import com.example.superheroapp.ui.screens.characters.uiState.CharacterUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val superheroes: List<Superhero>,
    private val enemies: List<Enemy>
) : ViewModel() {

    private val _uiState = MutableStateFlow(CharacterUiState())
    val uiState: StateFlow<CharacterUiState> = _uiState.asStateFlow()

    fun loadCharacters(isHero: Boolean) {
        viewModelScope.launch {
            _uiState.update {
                it.copy(
                    characterList = if (isHero) {
                        superheroes
                    } else {
                        enemies
                    }
                )
            }
        }
    }
}