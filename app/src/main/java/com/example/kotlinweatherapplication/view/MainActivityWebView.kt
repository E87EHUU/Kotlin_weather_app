package com.example.kotlinweatherapplication.view


import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.os.Looper
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinweatherapplication.R
import com.example.kotlinweatherapplication.databinding.ActivityMainWebviewBinding
import com.example.kotlinweatherapplication.view.weatherlist.WeatherListFragment
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL
import java.util.logging.Handler
import java.util.stream.Collectors
import javax.net.ssl.HttpsURLConnection
class MainActivityWebView : AppCompatActivity() {
    lateinit var binding: ActivityMainWebviewBinding
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainWebviewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.ok.setOnClickListener {
            val urlText = binding.etTextUrl.text.toString()
            val uri = URL(urlText)
            val urlConnection:HttpsURLConnection = (uri.openConnection() as HttpsURLConnection).apply {
                connectTimeout = 1000
                readTimeout = 1000
            }

            Thread{
                val headers = urlConnection.headerFields
                val buffer = BufferedReader(InputStreamReader(urlConnection.inputStream))
                val result = getLinesAsOneBigString(buffer)
                //binding.webview.loadUrl(urlText)
                /*runOnUiThread {
                    binding.webview.loadDataWithBaseURL(null,result,"text/html; utf-8","utf-8",null)
                }*/
                android.os.Handler(Looper.getMainLooper()).post {
                    binding.webview.settings.javaScriptEnabled = true
                    binding.webview.loadDataWithBaseURL(null,result,"text/html; utf-8","utf-8",null)
                }
            }.start()


        }
    }

       @RequiresApi(Build.VERSION_CODES.N)
       fun getLinesAsOneBigString (bufferedReader: BufferedReader):String {
           return bufferedReader.lines().collect(Collectors.joining("\n"))
       }

}



