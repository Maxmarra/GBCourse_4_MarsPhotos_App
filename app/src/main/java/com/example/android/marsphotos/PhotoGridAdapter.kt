package com.example.android.marsphotos


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.marsphotos.databinding.GridViewItemBinding
import com.example.android.marsphotos.domain.WeatherUnited

class PhotoGridAdapter : ListAdapter<WeatherUnited,
        PhotoGridAdapter.MarsPhotoViewHolder>(DiffCallback) {

            class MarsPhotoViewHolder(private var binding:GridViewItemBinding)
                : RecyclerView.ViewHolder(binding.root){

                    fun bind(marsPhoto: WeatherUnited){
                        binding.weather = marsPhoto
                        binding.executePendingBindings()
                    }
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            MarsPhotoViewHolder {
        return MarsPhotoViewHolder(GridViewItemBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    override fun onBindViewHolder(holder: MarsPhotoViewHolder, position: Int) {
        val marsPhoto = getItem(position)
        holder.bind(marsPhoto)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<WeatherUnited>() {
        override fun areItemsTheSame(
            oldItem: WeatherUnited, newItem: WeatherUnited): Boolean {
            return oldItem.temperature == newItem.temperature
        }

        override fun areContentsTheSame(
            oldItem: WeatherUnited, newItem: WeatherUnited): Boolean {
            return oldItem.speed == newItem.speed
        }
    }

}