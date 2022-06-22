package com.example.mars_1_drilling

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.mars_1_drilling.adapters.GridAdapter
import com.example.mars_1_drilling.databinding.FragmentMarsBinding
import com.example.mars_1_drilling.viewmodel.MarsViewModel

class MarsFragment : Fragment() {

    lateinit var binding: FragmentMarsBinding
    private val viewModel:MarsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMarsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.recyclerView.adapter = GridAdapter()

    }


}