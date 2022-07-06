package com.example.android.marsphotos.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.marsphotos.databinding.GridViewItemBinding
import com.example.android.marsphotos.domain.MarsPhotoDomain


class PhotoGridAdapter (val onItemClicked:(marsPhoto: MarsPhotoDomain)-> Unit) :
    ListAdapter<MarsPhotoDomain, PhotoGridAdapter.MarsPhotoViewHolder>(DiffCallback) {

    class MarsPhotoViewHolder(
        var binding: GridViewItemBinding
    ): RecyclerView.ViewHolder(binding.root) {

        fun bind(marsPhoto: MarsPhotoDomain) {
            binding.photo = marsPhoto
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarsPhotoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return  MarsPhotoViewHolder(
            GridViewItemBinding.inflate(
                layoutInflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MarsPhotoViewHolder, position: Int) {
        val marsPhoto = getItem(position)
        holder.bind(marsPhoto)
        holder.itemView.setOnClickListener {
            onItemClicked(marsPhoto)
        }

    }

    companion object DiffCallback : DiffUtil.ItemCallback<MarsPhotoDomain>() {
        override fun areItemsTheSame(oldItem: MarsPhotoDomain, newItem: MarsPhotoDomain): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MarsPhotoDomain, newItem: MarsPhotoDomain): Boolean {
            return oldItem.imgSrc == newItem.imgSrc
        }
    }
}