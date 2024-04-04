package com.example.advweek4160421118.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.advweek4160421118.R
import com.example.advweek4160421118.databinding.FragmentCarListBinding
import com.example.advweek4160421118.viewmodel.ListViewModelCar


class CarListFragment : Fragment() {
    private lateinit var viewModel: ListViewModelCar
    private val carListAdapter  = CarListAdapter(arrayListOf())
    private lateinit var binding: FragmentCarListBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCarListBinding.inflate(inflater,container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(ListViewModelCar::class.java)
        viewModel.refresh()

        binding.recViewCar.layoutManager = LinearLayoutManager(context)
        binding.recViewCar.adapter = carListAdapter
        binding.refreshLayout.setOnRefreshListener {
            binding.recViewCar.visibility = View.GONE
            binding.txtError.visibility = View.GONE
            binding.progressLoad.visibility = View.VISIBLE
            viewModel.refresh()
            binding.refreshLayout.isRefreshing = false
        }


        observeViewModel()
    }
    fun observeViewModel() {
        viewModel.carsLD.observe(viewLifecycleOwner, Observer {
            carListAdapter.updateStudentList(it)
        })
        viewModel.carLoadErrorLD.observe(viewLifecycleOwner, Observer {
            if(it == true) {
                binding.txtError?.visibility = View.VISIBLE
            } else {
                binding.txtError?.visibility = View.GONE
            }
        })
        viewModel.loadingLD.observe(viewLifecycleOwner, Observer {
            if(it == true) {
                binding.recViewCar.visibility = View.GONE
                binding.progressLoad.visibility = View.VISIBLE
            } else {
                binding.recViewCar.visibility = View.VISIBLE
                binding.progressLoad.visibility = View.GONE
            }
        })


    }


}