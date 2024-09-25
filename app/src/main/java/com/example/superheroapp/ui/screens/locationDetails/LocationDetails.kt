package com.example.superheroapp.ui.screens.locationDetails

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.superheroapp.MainActivity.Companion.CHARACTER
import com.example.superheroapp.R
import com.example.superheroapp.data.models.Character
import com.example.superheroapp.databinding.ActivityLocationDetailsBinding
import com.example.superheroapp.ui.screens.locationDetails.rv.RvLocationAdapter

class LocationDetails : AppCompatActivity() {

    private lateinit var binding: ActivityLocationDetailsBinding
    private lateinit var rvLocationAdapter: RvLocationAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLocationDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRv()
    }

    private fun initRv() {
        binding.tvCharacterName
    }

    fun getCharacter(){
        val character = intent.extras?.getParcelable<Character>(CHARACTER)
    }
}