package com.example.superheroapp.ui.screens.locationDetails

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.superheroapp.MainActivity.Companion.SUPER_HERO
import com.example.superheroapp.data.models.Superhero
import com.example.superheroapp.data.viewModel.LocationViewModel
import com.example.superheroapp.databinding.ActivityLocationDetailsBinding
import com.example.superheroapp.ui.screens.locationDetails.rv.RvLocationAdapter
import kotlinx.coroutines.launch

class LocationDetails : AppCompatActivity() {

    private lateinit var binding: ActivityLocationDetailsBinding
    private lateinit var rvLocationAdapter: RvLocationAdapter
    private val locationViewModel : LocationViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLocationDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRv()
        initUiStateLifecycle()
        getSuperhero()
    }

    private fun initRv() {
        rvLocationAdapter = RvLocationAdapter()
        binding.rvLocations.apply {
            layoutManager = LinearLayoutManager(this@LocationDetails)
            adapter = rvLocationAdapter
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initUiStateLifecycle(){
        lifecycleScope.launch {
            locationViewModel.uiState.collect{ uiState ->
                with(binding){
                    uiState.superHero?.let { superHero ->
                        tvCharacterId.text = superHero.id.toString()
                        tvCharacterName.text = superHero.name
                        tvCharacterAlterName.text = superHero.alterName
                        tvCharacterMainEnemy.text = superHero.mainEnemy.name
                        ivCharacterImage.setImageResource(superHero.photo)
                    }

                    if(uiState.locations.isNotEmpty()){
                        rvLocationAdapter.locations = uiState.locations
                        rvLocationAdapter.notifyDataSetChanged()
                    }
                }
            }
        }
    }

    fun getSuperhero(){
        val superhero = intent.extras?.getParcelable<Superhero>(SUPER_HERO)
        superhero?.let {
            locationViewModel.setSuperHero(superhero)
        }
    }
}