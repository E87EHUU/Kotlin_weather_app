package com.example.kotlinweatherapplication.repository

class RepositoryImpl:Repository {
    override fun getWeatherFromServer():Weather {
        Thread.sleep(2000L) // эмуляция сетевого запроса
        return Weather()
    }

    override fun getWeatherFromLocalStorage():Weather {
        Thread.sleep(2000L) // эмуляция локального запроса
        return Weather()
    }
}