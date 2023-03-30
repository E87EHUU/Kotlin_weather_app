package com.example.kotlinweatherapplication.viewmodel

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlinweatherapplication.repository.Repository
import com.example.kotlinweatherapplication.repository.RepositoryImpl
import com.example.kotlinweatherapplication.repository.Weather
import java.lang.Thread.sleep

class MainViewModel(private val liveData:MutableLiveData<AppState> = MutableLiveData(),
                    private val repository: RepositoryImpl = RepositoryImpl()
):ViewModel() {

    fun getaData(): LiveData<AppState> {
        return liveData
    }


    fun getWeatherRussia() = getWeather(true)
    fun getWeatherWorld() = getWeather(false)
    private fun getWeather(isRussian:Boolean){
        Thread {
            liveData.postValue(AppState.Loading)

            if ((0..10).random()>0)
            {

                val answer =
                    if (!isRussian) repository.getWorldWeatherFromLocalStorage() else repository.getRussianWeatherFromLocalStorage()
                liveData.postValue(AppState.Success(answer))
            }
            else
                liveData.postValue(AppState.Error(IllegalAccessException()))
        }.start()

    }

}