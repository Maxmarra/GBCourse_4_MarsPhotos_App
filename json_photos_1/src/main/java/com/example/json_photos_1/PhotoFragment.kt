package com.example.json_photos_1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.json_photos_1.adapters.PhotoGridAdapter
import com.example.json_photos_1.databinding.FragmentPhotoBinding
import com.example.json_photos_1.viewmodel.PhotoViewModel

class PhotoFragment : Fragment() {

    private val viewModel:PhotoViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentPhotoBinding.inflate(inflater)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.recyclerView.adapter = PhotoGridAdapter()

        return binding.root
    }


}