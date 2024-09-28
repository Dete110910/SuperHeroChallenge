package com.example.superheroapp.ui.screens.characters.rv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.superheroapp.data.models.Character
import java.util.Objects

import com.example.superheroapp.data.models.Superhero
import com.example.superheroapp.databinding.ActivityCharacterBinding

class RvCharacterAdapter(
    private val onLocationClickListener: (superhero: Superhero) ->Unit,
    private val onPowersClickListener: (superhero: Superhero) -> Unit
) : RecyclerView.Adapter<CharacterViewHolder>() {

    var characters = emptyList<Character>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val binding = ActivityCharacterBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CharacterViewHolder(binding = binding,
            onLocationClickListener = onLocationClickListener,
            onPowersClickListener= onPowersClickListener
            )
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(characters[position])
    }

    override fun getItemCount(): Int = characters.size
}