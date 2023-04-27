package com.example.kotlinweatherapplication.repository

interface OnServerResponse {
    fun onResponse(weatherDTO: WeatherDTO)
}