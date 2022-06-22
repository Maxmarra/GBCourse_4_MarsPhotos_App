package com.example.mars_3_drilling

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mars_3_drilling.adapters.MarsAdapter
import com.example.mars_3_drilling.databinding.FragmentMarsBinding
import com.example.mars_3_drilling.viewmodel.MarsViewModel

class MarsFragment : Fragment() {

    private val viewModel:MarsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentMarsBinding.inflate(inflater)

        binding.viewmodel = viewModel
        binding.lifecycleOwner = this

        binding.fragmentRecyclerview.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.fragmentRecyclerview.adapter = MarsAdapter()


        return binding.root
    }


}