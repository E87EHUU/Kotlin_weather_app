package com.example.kotlinweatherapplication.repository

interface Repository {
    fun getWeatherFromServer():Weather
    fun getWorldWeatherFromLocalStorage(): List<Weather>
    fun getRussianWeatherFromLocalStorage(): List<Weather>
}