package com.example.superheroapp.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
open class Character(
    val identification: Int,
    val characterName: String,
    val characterPhoto: Int
) : Parcelable
