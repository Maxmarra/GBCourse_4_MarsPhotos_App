package com.example.android.marsphotos


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.marsphotos.databinding.GridViewItemBinding
import com.example.android.marsphotos.domain.WeatherUnited
import com.example.android.marsphotos.network.DataList

class WeatherAdapter : ListAdapter<WeatherUnited,
        WeatherAdapter.WeatherViewHolder>(DiffCallback) {

            class WeatherViewHolder(private var binding:GridViewItemBinding)
                : RecyclerView.ViewHolder(binding.root){

                    fun bind(weatherUnited: WeatherUnited){
                        binding.weatherUnited = weatherUnited
                        binding.executePendingBindings()
                    }
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            WeatherViewHolder {
        return WeatherViewHolder(GridViewItemBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        val weather = getItem(position)
        holder.bind(weather)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<WeatherUnited>() {
        override fun areItemsTheSame(
            oldItem: WeatherUnited, newItem: WeatherUnited): Boolean {
            return oldItem.temperature == newItem.temperature
        }

        override fun areContentsTheSame(
            oldItem: WeatherUnited, newItem: WeatherUnited): Boolean {
            return oldItem.temperature == oldItem.temperature
        }
    }

}