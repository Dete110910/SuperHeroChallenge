package com.example.superheroapp.ui.screens.powerDetails.rv

import androidx.recyclerview.widget.RecyclerView
import com.example.superheroapp.R
import com.example.superheroapp.data.models.Power
import com.example.superheroapp.databinding.PowerViewBinding

class PowerViewHolder(
    private val binding: PowerViewBinding
) : RecyclerView.ViewHolder(binding.root
) {

    fun bind(power: Power) {
        with(binding){
            tvPowerId.text= tvPowerId.context.getString(R.string.power_id, power.id.toString())
            tvPowerName.text= tvPowerName.context.getString(R.string.power_name, power.name)
        }
    }
}
