package com.example.superheroapp.ui.screens.powerDetails

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.superheroapp.R
import com.example.superheroapp.databinding.ActivityPowerDetailsBinding
import kotlinx.coroutines.launch

class PowerDetails : AppCompatActivity() {

    private lateinit var binding: ActivityPowerDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPowerDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRV()

    }

    private fun initRV() {
        Log.d("PowerDetails", "initRV: ")

    }

    private fun initUiStateLifecycle(){
        lifecycleScope.launch {


        }

    }
}