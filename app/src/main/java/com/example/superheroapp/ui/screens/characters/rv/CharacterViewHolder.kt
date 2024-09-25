package com.example.superheroapp.ui.screens.characters.rv

import androidx.recyclerview.widget.RecyclerView
import com.example.superheroapp.databinding.ActivityCharacterBinding
import com.example.superheroapp.data.models.Character


class CharacterViewHolder(
    private val binding: ActivityCharacterBinding
): RecyclerView.ViewHolder(binding.root){

    fun bind(characters: Character){
        binding.tvCharacterId.text = characters.identification.toString()
        binding.tvCharacterName.text = characters.characterName
        binding.ivCharacterImage.setImageResource(characters.characterPhoto)
    }
}
