package com.example.kotlinweatherapplication.view.weatherlist

import com.example.kotlinweatherapplication.repository.Weather

interface OnItemClickListener {

    fun onItemClick(weather:Weather)
}