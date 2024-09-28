package com.example.superheroapp.ui.screens.powerDetails.rv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.superheroapp.data.models.Power
import com.example.superheroapp.databinding.PowerViewBinding

class RvPowerAdapter (): RecyclerView.Adapter<PowerViewHolder>() {

    var powers : List<Power> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PowerViewHolder {
        val binding = PowerViewBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return PowerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PowerViewHolder, position: Int) {
        holder.bind(powers[position])
    }

    override fun getItemCount(): Int = powers.size
}