package com.example.android.marsphotos
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.marsphotos.databinding.GridViewItemBinding
import com.example.android.marsphotos.model.ModelMovie
import com.example.android.marsphotos.network.NetworkMovie

class MovieGridAdapter : ListAdapter<ModelMovie,MovieGridAdapter.MovieViewHolder>(DiffCallback) {

    class MovieViewHolder(private val binding: GridViewItemBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(movie: ModelMovie) {
            binding.movie = movie
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(GridViewItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = getItem(position)
        holder.bind(movie)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<ModelMovie>() {
        override fun areItemsTheSame(oldItem: ModelMovie, newItem: ModelMovie): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: ModelMovie, newItem: ModelMovie): Boolean {
            return oldItem.posterPath == newItem.posterPath
        }
    }

}