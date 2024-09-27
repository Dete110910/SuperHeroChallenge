package com.example.superheroapp.ui.screens.locationDetails.rv

import com.example.superheroapp.data.models.Location
import androidx.recyclerview.widget.RecyclerView
import com.example.superheroapp.R
import com.example.superheroapp.databinding.LocationViewBinding

class LocationViewHolder(
    private val binding: LocationViewBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(location: Location) {
        with(binding){
            tvLocationId.text = tvLocationId.context.getString(R.string.location_id, location.id.toString())
            tvLocationName.text =tvLocationName.context.getString(R.string.location_name, location.name)
        }
    }
}