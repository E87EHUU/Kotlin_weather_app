package com.example.kotlinweatherapplication.repository

import com.google.gson.annotations.SerializedName

data class WeatherDTO(

    @field:SerializedName("fact")
    val factDTO: FactDTO,

    @field:SerializedName("forecast")
    val forecastDTO: ForecastDTO,

    @field:SerializedName("info")
    val infoDTO: InfoDTO,

    @field:SerializedName("now")
    val now: Int,

    @field:SerializedName("now_dt")
    val nowDt: String
)