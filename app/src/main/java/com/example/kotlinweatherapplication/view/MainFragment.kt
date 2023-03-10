package com.example.kotlinweatherapplication.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.kotlinweatherapplication.R
import com.example.kotlinweatherapplication.databinding.FragmentMainBinding
import com.example.kotlinweatherapplication.viewmodel.MainViewModel


class MainFragment : Fragment() {

    lateinit var binding:FragmentMainBinding //утечка памяти

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater,container,false)
        //return inflater.inflate(R.layout.fragment_main, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnOne.setOnClickListener{}
        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        //val observer = Observer<Any>{renderData(it)}
        val observer = object:Observer<Any>{
            override fun onChanged(data: Any) {
                renderData(data)
            }
        }
        viewModel.getaData().observe(viewLifecycleOwner,observer)

        viewModel.getWeather()
    }

    private fun renderData(data:Any) {
        Toast.makeText(requireContext(),"Работает",Toast.LENGTH_SHORT).show()
    }


    companion object {

        @JvmStatic
        fun newInstance() =   MainFragment()
                }
            }

