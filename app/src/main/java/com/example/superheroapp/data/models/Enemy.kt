package com.example.superheroapp.data.models

import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class Enemy(
    val id: Int,
    val name: String,
    @DrawableRes val photo: Int
) : Character(id, name, photo)
