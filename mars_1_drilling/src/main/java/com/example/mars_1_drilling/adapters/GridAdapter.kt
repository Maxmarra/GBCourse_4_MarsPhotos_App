package com.example.mars_1_drilling.adapters


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mars_1_drilling.databinding.MarsPhotoItemLayoutBinding
import com.example.mars_1_drilling.network.MarsPhoto

class GridAdapter: ListAdapter<MarsPhoto, GridAdapter.MarsViewHolder>(DiffCallBack) {

    class MarsViewHolder(private val binding: MarsPhotoItemLayoutBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(marsPhoto: MarsPhoto){
            binding.photo = marsPhoto
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarsViewHolder {
        return MarsViewHolder(MarsPhotoItemLayoutBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: MarsViewHolder, position: Int) {
        val marsPhoto = getItem(position)
        holder.bind(marsPhoto)
    }

    companion object DiffCallBack : DiffUtil.ItemCallback<MarsPhoto>() {
        override fun areItemsTheSame(oldItem: MarsPhoto, newItem: MarsPhoto): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MarsPhoto, newItem: MarsPhoto): Boolean {
            return oldItem.imgSrcUrl == newItem.imgSrcUrl
        }
    }


}