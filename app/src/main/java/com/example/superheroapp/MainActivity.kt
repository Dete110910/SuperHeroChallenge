package com.example.superheroapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.superheroapp.databinding.ActivityMainBinding
import com.example.superheroapp.ui.screens.characters.rv.RvCharacterAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var rvCharactersAdapter : RvCharacterAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRV()
    }

    private fun initRV() {
        rvCharactersAdapter = RvCharacterAdapter()
        binding.rvHeroesVillans.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = rvCharactersAdapter
        }

    }
}