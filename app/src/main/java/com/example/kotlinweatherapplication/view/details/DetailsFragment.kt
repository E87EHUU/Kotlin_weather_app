package com.example.kotlinweatherapplication.view.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kotlinweatherapplication.databinding.FragmentDetailsBinding
import com.example.kotlinweatherapplication.repository.OnServerResponse
import com.example.kotlinweatherapplication.repository.Weather
import com.example.kotlinweatherapplication.repository.WeatherDTO
import com.example.kotlinweatherapplication.repository.WeatherLoader
import com.example.kotlinweatherapplication.utils.KEY_BUNDLE_KEY
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_details.*
import kotlinx.android.synthetic.main.fragment_details.view.*


class DetailsFragment : Fragment(), OnServerResponse {

    private var _binding: FragmentDetailsBinding? = null
    private val binding: FragmentDetailsBinding
        get() {
            return _binding!!
        }

    override fun onDestroy() {
        super.onDestroy()
        //binding=null
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        //return inflater.inflate(R.layout.fragment_main, container, false)
        return binding.root
    }

    lateinit var currentCityName: String

    @Suppress("DEPRECATION")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getParcelable<Weather>(KEY_BUNDLE_KEY)?.let {
            currentCityName = it.city.name
            Thread {
                WeatherLoader(this@DetailsFragment).loadWeather(it.city.lat, it.city.lon)
            }.start()
        }
    }

    private fun renderData(weather: WeatherDTO) {
        with(binding) {
            loadingLayout.visibility = View.GONE
            cityName.text = currentCityName
            with(weather) {
                temperatureValue.text = weather.factDTO.temperature.toString()
                feelsLikeValue.text = weather.factDTO.feelsLike.toString()
                cityCoordinates.text = "${weather.infoDTO.lat} ${weather.infoDTO.lon}"
            }
        }
        //Snackbar.make(binding.mainView, "Получилось", Snackbar.LENGTH_LONG).show()
        mainView.showSnackBar()
    }

    private fun View.showSnackBar() {
        Snackbar.make(binding.mainView, "Получилось", Snackbar.LENGTH_LONG).show()
    }

    companion object {
        fun newInstance(bundle: Bundle): DetailsFragment {
            val fragment = DetailsFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onResponse(weatherDTO: WeatherDTO) {

            renderData(weatherDTO)
        }

    }




