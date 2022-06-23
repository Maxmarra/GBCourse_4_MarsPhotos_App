package com.example.android.marsphotos


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.marsphotos.databinding.GridViewItemBinding
import com.example.android.marsphotos.network.MarsPhoto

class PhotoGridAdapter(private val clickListener: MarsPhotoListener) : ListAdapter<MarsPhoto,
        PhotoGridAdapter.MarsPhotoViewHolder>(DiffCallback) {

            class MarsPhotoViewHolder(private var binding:GridViewItemBinding)
                : RecyclerView.ViewHolder(binding.root){

                    fun bind(clickListener: MarsPhotoListener,
                             marsPhoto: MarsPhoto){
                        binding.photo = marsPhoto
                        binding.clickListener = clickListener
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
        holder.bind(clickListener, marsPhoto)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<MarsPhoto>() {
        override fun areItemsTheSame(
            oldItem: MarsPhoto, newItem: MarsPhoto): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: MarsPhoto, newItem: MarsPhoto): Boolean {
            return oldItem.imgSrcUrl == newItem.imgSrcUrl
        }
    }

}

class MarsPhotoListener(val clickListener: (marsPhoto: MarsPhoto) -> Unit) {
    fun onClick(marsPhoto: MarsPhoto) = clickListener(marsPhoto)
}