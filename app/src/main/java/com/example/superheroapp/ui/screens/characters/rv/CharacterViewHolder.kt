package com.example.superheroapp.ui.screens.characters.rv

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.superheroapp.databinding.ActivityCharacterBinding
import com.example.superheroapp.data.models.Character
import com.example.superheroapp.data.models.Enemy
import com.example.superheroapp.data.models.Superhero


class CharacterViewHolder(
    private val binding: ActivityCharacterBinding,
    private val onLocationClickListener: (superHero: Superhero) ->Unit,
    private val onPowersClickListener: (characeter: Character) -> Unit
): RecyclerView.ViewHolder(binding.root){

    fun bind(characters: Character){
        binding.tvCharacterId.text = characters.identification.toString()
        binding.tvCharacterName.text = characters.characterName
        binding.ivCharacterImage.setImageResource(characters.characterPhoto)

        when(characters){
            is Superhero -> {
                binding.btnLocations.setOnClickListener{
                    onLocationClickListener(characters)
                }
                binding.btnPowers.setOnClickListener {
                    onPowersClickListener(characters)
                }
                binding.btnPowers.visibility = View.VISIBLE
                binding.btnLocations.visibility = View.VISIBLE
            }
            is Enemy -> {
                binding.btnPowers.visibility = View.INVISIBLE
                binding.btnLocations.visibility = View.INVISIBLE
            }
        }
    }
}
