package com.example.kotlinweatherapplication.viewmodel

sealed class AppState {
    object Loading:AppState()
    data class Success(val weatherData:Any):AppState()
        fun test(){}
    data class Error(val error:Throwable):AppState() {

    }
}

//data class SuccessNew(val weatherData: Any):AppState()