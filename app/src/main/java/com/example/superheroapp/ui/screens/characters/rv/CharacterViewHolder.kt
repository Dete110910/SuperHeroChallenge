package com.example.superheroapp.ui.screens.characters.rv

import androidx.recyclerview.widget.RecyclerView
import com.example.superheroapp.databinding.ActivityCharacterBinding
import com.example.superheroapp.data.models.Superhero


class CharacterViewHolder(
    private val binding: ActivityCharacterBinding
): RecyclerView.ViewHolder(binding.root){

    fun bind(characters: Superhero){
        binding.tvCharacterId.text = characters.id.toString()
        binding.tvCharacterName.text = characters.name
        binding.ivCharacterImage.setImageResource(characters.photo)
    }

}
