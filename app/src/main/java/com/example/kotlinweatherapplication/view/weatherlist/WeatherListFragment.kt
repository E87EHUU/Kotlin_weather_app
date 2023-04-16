package com.example.kotlinweatherapplication.view.weatherlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.kotlinweatherapplication.R
import com.example.kotlinweatherapplication.databinding.FragmentWeatherListBinding
import com.example.kotlinweatherapplication.repository.Weather
import com.example.kotlinweatherapplication.utils.KEY_BUNDLE_KEY
import com.example.kotlinweatherapplication.view.details.DetailsFragment
import com.example.kotlinweatherapplication.viewmodel.AppState
import com.example.kotlinweatherapplication.viewmodel.MainViewModel
import com.google.android.material.snackbar.Snackbar


class WeatherListFragment : Fragment(), OnItemClickListener {

    private var _binding: FragmentWeatherListBinding? = null
    private val binding: FragmentWeatherListBinding
        get() {
            return _binding!!
        }

    private val adapter = WeatherListAdapter(this) //private

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWeatherListBinding.inflate(inflater, container, false)
        //return inflater.inflate(R.layout.fragment_main, container, false)
        return binding.root
    }

    var isRussian = true

    private val viewModel:MainViewModel by lazy {
      ViewModelProvider(this)[MainViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //binding.btnOne.setOnClickListener{}

        binding.recyclerView.adapter = adapter


        //val observer = Observer<Any>{renderData(it)}
        val observer =  { data: AppState -> renderData(data)}

        viewModel.getaData().observe(viewLifecycleOwner, observer)

        binding.floatingActionButton.setOnClickListener {
            isRussian = !isRussian
            if (isRussian) {
                viewModel.getWeatherRussia()
                binding.floatingActionButton.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.ic_russia
                    )
                )
            } else {
                viewModel.getWeatherWorld()
                binding.floatingActionButton.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.ic_earth
                    )
                )
            }
        }
        viewModel.getWeatherRussia()
    }

    private fun renderData(data: AppState) = when (data) {
        is AppState.Error -> {
            binding.loadingLayout.visibility = View.GONE
            Snackbar.make(binding.root, "Не получилось ${data.error}", Snackbar.LENGTH_LONG).show()

        }
        is AppState.Loading -> {
            binding.loadingLayout.visibility = View.VISIBLE
        }
        is AppState.Success -> {
            binding.loadingLayout.visibility = View.GONE

            adapter.setData(data.weatherList)
            binding.recyclerView.adapter = adapter
        }
    }


    companion object {


        fun newInstance() = WeatherListFragment()
    }

    override fun onItemClick(weather: Weather) {
        requireActivity().supportFragmentManager.beginTransaction().add(
            R.id.container,

            DetailsFragment.newInstance(Bundle().apply {
            putParcelable (KEY_BUNDLE_KEY, weather)
            })
        ).addToBackStack("").commit()
    }
}

