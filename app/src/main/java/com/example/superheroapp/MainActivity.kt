package com.example.superheroapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.superheroapp.databinding.ActivityMainBinding
import com.example.superheroapp.ui.screens.characters.rv.RvCharacterAdapter
import com.example.superheroapp.data.models.Character
import com.example.superheroapp.data.models.Superhero
import com.example.superheroapp.data.viewModel.CharactersViewModel
import com.example.superheroapp.ui.screens.locationDetails.LocationDetails
import com.example.superheroapp.ui.screens.powerDetails.PowerDetails
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var rvCharactersAdapter: RvCharacterAdapter
    private val characterViewModel: CharactersViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRV()
        setListeners()
        initUiStateLifecycle()

        characterViewModel.loadCharacters(isHero = true)
    }

    private fun initRV() {
        rvCharactersAdapter = RvCharacterAdapter(
            onLocationClickListener = {superHero ->
                launchLocationActivity(superHero)
            },
        onPowersClickListener ={ character ->
            launchCharacterPowerDetails(character)
        }

        )
        binding.rvHeroesVillans.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = rvCharactersAdapter
        }
    }

    private fun setListeners() {
        binding.btnSuperHero.setOnClickListener {
            characterViewModel.loadCharacters(isHero = true)
        }

        binding.btnVillian.setOnClickListener {
            characterViewModel.loadCharacters(isHero = false)
        }
    }

    private fun launchCharacterPowerDetails(character: Character) {
        startActivity(
            Intent(
                this,
                PowerDetails::class.java
            )
        )

    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initUiStateLifecycle() {
        lifecycleScope.launch {
            characterViewModel.uiState.collect { uiState ->
                uiState.characterList.let { characterList ->
                    rvCharactersAdapter.characters = characterList
                    rvCharactersAdapter.notifyDataSetChanged()
                }
            }
        }
    }

    private fun launchLocationActivity(superHero: Superhero) {
        startActivity(
            Intent(
                this,
                LocationDetails::class.java
            ).apply {
                putExtras(
                    bundleOf(
                        SUPER_HERO to superHero
                    )
                )
            }
        )
    }

    companion object {
        const val SUPER_HERO = "superHero"
    }
}