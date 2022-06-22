package com.example.mars_3_drilling.adapters

import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.mars_3_drilling.R
import com.example.mars_3_drilling.network.MarsPhoto
import com.example.mars_3_drilling.viewmodel.ConnectionStatus

@BindingAdapter("imgUrl")
fun bindImage(imageView: ImageView, imageUrl: String?){
    imageUrl?.let {
        val imageUri = imageUrl.toUri().buildUpon().scheme("https").build()
        imageView.load(imageUri){
            placeholder(R.drawable.loading_animation)
            error(R.drawable.ic_broken_image)
        }
    }
}

@BindingAdapter("connectionStatus")
fun bindStatus(imageView: ImageView, status:ConnectionStatus?){
    when(status){
        ConnectionStatus.LOADING ->{
            imageView.visibility = View.VISIBLE
            imageView.setImageResource(R.drawable.loading_animation)
        }

        ConnectionStatus.ERROR ->{
            imageView.visibility = View.VISIBLE
            imageView.setImageResource(R.drawable.ic_connection_error)
        }

        ConnectionStatus.DONE ->{
            imageView.visibility = View.GONE

        }
    }
}


@BindingAdapter("liveData")
fun bindGridAdapter(recyclerView: RecyclerView, data:List<MarsPhoto>?){
    val adapter = recyclerView.adapter as MarsAdapter
    adapter.submitList(data)
}
