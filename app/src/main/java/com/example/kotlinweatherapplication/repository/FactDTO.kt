package com.example.kotlinweatherapplication.repository

import com.google.gson.annotations.SerializedName

data class FactDTO(

    @field:SerializedName("condition")
    val condition: String,

    @field:SerializedName("daytime")
    val daytime: String,

    @field:SerializedName("feels_like")
    val feelsLike: Int,

    @field:SerializedName("humidity")
    val humidity: Int,

    @field:SerializedName("icon")
    val icon: String,

    @field:SerializedName("obs_time")
    val obsTime: Int,

    @field:SerializedName("polar")
    val polar: Boolean,

    @field:SerializedName("pressure_mm")
    val pressureMm: Int,

    @field:SerializedName("pressure_pa")
    val pressurePa: Int,

    @field:SerializedName("season")
    val season: String,

    @field:SerializedName("temp")
    val temp: Int,

    @field:SerializedName("wind_dir")
    val windDir: String,

    @field:SerializedName("wind_gust")
    val windGust: Double,

    @field:SerializedName("wind_speed")
    val windSpeed: Int
)