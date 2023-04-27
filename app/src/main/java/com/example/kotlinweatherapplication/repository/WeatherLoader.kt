package com.example.kotlinweatherapplication.repository

import android.net.wifi.p2p.WifiP2pManager.DnsSdServiceResponseListener
import android.os.Handler
import android.os.Looper
import com.example.kotlinweatherapplication.BuildConfig
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import javax.net.ssl.HttpsURLConnection

class WeatherLoader(private val onServerResponseListener: OnServerResponse) {

    fun loadWeather(lat: Double, lon: Double) {

            val urlText = "https://api.weather.yandex.ru/v2/informers?lat=$lat&lon=$lon"
            val uri = URL(urlText)
            val urlConnection: HttpsURLConnection =
                (uri.openConnection() as HttpsURLConnection).apply {
                    connectTimeout = 1000
                    readTimeout = 1000
                    addRequestProperty("X-Yandex-API-Key", BuildConfig.WEATHER_API_KEY )
                }

            /*val headers = urlConnection.headerFields
            val responseCode = urlConnection.responseCode
            val buffer = BufferedReader(InputStreamReader(urlConnection.inputStream))
            //val result = (buffer.toString())

            val weatherDTO: WeatherDTO = Gson().fromJson(buffer, WeatherDTO::class.java)
            Handler(Looper.getMainLooper()).post { onServerResponseListener.onResponse(weatherDTO) }*/


            Thread {
                try {
                    val headers = urlConnection.headerFields
                    val buffer = BufferedReader(InputStreamReader(urlConnection.inputStream))
                    val weatherDTO: WeatherDTO = Gson().fromJson(buffer, WeatherDTO::class.java)

                    android.os.Handler(Looper.getMainLooper()).post {
                        onServerResponseListener.onResponse(weatherDTO)
                        }
                    //делаем отложенный вызов, когда будет готов вызов в главном потоке
                } catch (e: JsonSyntaxException) {

                } finally {
                    urlConnection.disconnect()
                }

            }.start()

        }
    }
