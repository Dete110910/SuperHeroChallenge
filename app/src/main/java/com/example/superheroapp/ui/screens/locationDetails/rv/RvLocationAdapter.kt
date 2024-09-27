package com.example.superheroapp.ui.screens.locationDetails.rv

import com.example.superheroapp.data.models.Location
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.superheroapp.databinding.LocationViewBinding

class RvLocationAdapter() : RecyclerView.Adapter<LocationViewHolder>() {

    var locations : List<Location> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        val binding = LocationViewBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return LocationViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        holder.bind(locations[position])
    }

    override fun getItemCount(): Int = locations.size

}
