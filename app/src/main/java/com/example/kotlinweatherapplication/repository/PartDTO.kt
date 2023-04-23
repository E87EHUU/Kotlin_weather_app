package com.example.kotlinweatherapplication.repository

import com.google.gson.annotations.SerializedName

data class PartDTO(

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

    @field:SerializedName("part_name")
    val partName: String,

    @field:SerializedName("polar")
    val polar: Boolean,

    @field:SerializedName("prec_mm")
    val precMm: Int,

    @field:SerializedName("prec_period")
    val precPeriod: Int,

    @field:SerializedName("prec_prob")
    val prec_prob: Int,

    @field:SerializedName("pressure_mm")
    val pressureMm: Int,

    @field:SerializedName("pressure_pa")
    val pressurePa: Int,

    @field:SerializedName("temp_avg")
    val tempAvg: Int,

    @field:SerializedName("temp_max")
    val tempMax: Int,

    @field:SerializedName("temp_min")
    val tempMin: Int,

    @field:SerializedName("wind_dir")
    val windDir: String,

    @field:SerializedName("wind_gust")
    val windGust: Double,

    @field:SerializedName("wind_speed")
    val windSpeed: Double
)