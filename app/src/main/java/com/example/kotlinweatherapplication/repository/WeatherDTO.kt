package com.example.kotlinweatherapplication.repository

import com.google.gson.annotations.SerializedName

data class WeatherDTO(

    @field:SerializedName("fact")
    val fact: FactDTO,

    @field:SerializedName("forecast")
    val forecast: ForecastDTO,

    @field:SerializedName("info")
    val info: InfoDTO,

    @field:SerializedName("now")
    val now: Int,

    @field:SerializedName("now_dt")
    val nowDt: String
)