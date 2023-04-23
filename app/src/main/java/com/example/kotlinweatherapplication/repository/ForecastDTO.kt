package com.example.kotlinweatherapplication.repository

import com.google.gson.annotations.SerializedName

data class ForecastDTO(

    @field:SerializedName("date")
    val date: String,

    @field:SerializedName("date_ts")
    val dateTs: Int,

    @field:SerializedName("moon_code")
    val moon_code: Int,

    @field:SerializedName("moon_text")
    val moonText: String,

    @field:SerializedName("parts")
    val parts: List<PartDTO>,

    @field:SerializedName("sunrise")
    val sunrise: String,

    @field:SerializedName("sunset")
    val sunset: String,

    @field:SerializedName("week")
    val week: Int
)