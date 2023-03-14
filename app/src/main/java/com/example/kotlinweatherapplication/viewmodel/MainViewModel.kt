package com.example.kotlinweatherapplication.viewmodel

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.lang.Thread.sleep

class MainViewModel(private val liveData:MutableLiveData<AppState> = MutableLiveData()):ViewModel() {

    fun getaData(): LiveData<AppState> {
        return liveData
    }

    fun getWeather(){
        Thread {
            liveData.postValue(AppState.Loading)
            sleep(2000L)
            if((0..10).random()>5)
            liveData.postValue(AppState.Success(Any()))
            else
                liveData.postValue(AppState.Error(IllegalAccessException()))
        }.start()

    }

}