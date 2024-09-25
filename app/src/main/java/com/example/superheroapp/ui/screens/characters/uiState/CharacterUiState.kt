package com.example.superheroapp.ui.screens.characters.uiState

import com.example.superheroapp.data.models.Character


data class CharacterUiState(
    val characterList: List<Character> = emptyList()
)
