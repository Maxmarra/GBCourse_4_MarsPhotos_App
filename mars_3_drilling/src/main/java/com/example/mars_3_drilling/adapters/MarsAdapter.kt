package com.example.mars_3_drilling.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mars_3_drilling.databinding.ItemLayoutBinding
import com.example.mars_3_drilling.network.MarsPhoto

class MarsAdapter : ListAdapter<MarsPhoto, MarsAdapter.MarsViewHolder>(DiffCall) {

    class MarsViewHolder(val binding: ItemLayoutBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(marsPhoto: MarsPhoto){
            binding.photo = marsPhoto
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarsViewHolder {
        return MarsViewHolder(ItemLayoutBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: MarsViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    companion object DiffCall : DiffUtil.ItemCallback<MarsPhoto>() {
        override fun areItemsTheSame(oldItem: MarsPhoto, newItem: MarsPhoto): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MarsPhoto, newItem: MarsPhoto): Boolean {
            return oldItem.imgSrcUrl == oldItem.imgSrcUrl
        }
    }
}