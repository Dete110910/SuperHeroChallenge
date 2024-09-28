package com.example.superheroapp.ui.screens.powerDetails

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.superheroapp.MainActivity.Companion.SUPER_HERO
import com.example.superheroapp.R
import com.example.superheroapp.data.models.Superhero
import com.example.superheroapp.data.viewModel.PowerViewModel
import com.example.superheroapp.databinding.ActivityPowerDetailsBinding
import com.example.superheroapp.ui.screens.powerDetails.rv.RvPowerAdapter
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class PowerDetails : AppCompatActivity() {

    private lateinit var binding: ActivityPowerDetailsBinding
    private lateinit var rvPowerAdapter: RvPowerAdapter
    private val powerViewModel : PowerViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPowerDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRV()
        initUiStateLifecycle()
        getSuperhero()
    }

    private fun initRV() {
        rvPowerAdapter = RvPowerAdapter()
        binding.rvPowers.apply {
            layoutManager = LinearLayoutManager(this@PowerDetails)
            adapter = rvPowerAdapter
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initUiStateLifecycle() {
        lifecycleScope.launch {
            powerViewModel.uiState.collect { uiState ->
                with(binding) {
                    uiState.superHero?.let { superHero ->
                        tvCharacterId.text = superHero.id.toString()
                        tvCharacterName.text = superHero.name
                        tvCharacterAlterName.text = superHero.alterName
                        tvCharacterMainEnemy.text = superHero.mainEnemy.name
                        ivCharacterImage.setImageResource(superHero.photo)
                    }
                    if (uiState.powers.isNotEmpty()) {
                        rvPowerAdapter.powers = uiState.powers
                        rvPowerAdapter.notifyDataSetChanged()
                    }
                }

            }
        }
    }

    fun getSuperhero(){
        val superhero = intent.extras?.getParcelable<Superhero>(SUPER_HERO)
        superhero?.let {
            powerViewModel.setSuperHero(superhero)
        }
    }
}