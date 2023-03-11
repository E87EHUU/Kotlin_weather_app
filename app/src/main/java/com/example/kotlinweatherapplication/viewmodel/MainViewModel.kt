package com.example.kotlinweatherapplication.viewmodel

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.lang.Thread.sleep

class MainViewModel(private val liveData:MutableLiveData<Any> = MutableLiveData()):ViewModel() {

    fun getaData(): LiveData<Any> {
        return liveData
    }

    fun getWeather(){
        Thread {
            sleep(1000L)
            liveData.postValue(Any())
        }.start()

    }

}