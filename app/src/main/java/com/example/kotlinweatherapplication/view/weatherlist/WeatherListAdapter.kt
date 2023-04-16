package com.example.kotlinweatherapplication.view.weatherlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinweatherapplication.R
import com.example.kotlinweatherapplication.databinding.FragmentWeatherListRecyclerItemBinding
import com.example.kotlinweatherapplication.repository.Weather
import com.example.kotlinweatherapplication.utils.KEY_BUNDLE_KEY
import com.example.kotlinweatherapplication.view.MainActivity

class WeatherListAdapter(
    private val onItemClickListener: OnItemClickListener, private var data:
    List<Weather> = listOf()
) :
    RecyclerView.Adapter<WeatherListAdapter.CityHolder>() {

    fun setData(dataNew: List<Weather>) {
        this.data = dataNew
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityHolder {
        val binding = FragmentWeatherListRecyclerItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CityHolder(binding.root)
    }

    override fun onBindViewHolder(holder: CityHolder, position: Int) {
        holder.bind(data.get(position))
    }

    override fun getItemCount() = data.size

    inner class CityHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(weather: Weather) {
             FragmentWeatherListRecyclerItemBinding.bind(itemView).apply {
                 tvCityName.text = weather.city.name
                 root.setOnClickListener {
                     onItemClickListener.onItemClick(weather)
             }
            }
        }
    }
}
