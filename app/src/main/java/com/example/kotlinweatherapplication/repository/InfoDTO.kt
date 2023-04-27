package com.example.kotlinweatherapplication.repository

import com.google.gson.annotations.SerializedName

data class InfoDTO(

    @field:SerializedName("lon")
    val lon: Double,

    @field:SerializedName("url")
    val url: String,

    @field:SerializedName("lat")
    val lat: Double
)