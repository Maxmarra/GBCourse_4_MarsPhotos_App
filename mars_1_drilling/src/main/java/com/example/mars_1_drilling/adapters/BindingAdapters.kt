package com.example.mars_1_drilling.adapters

import android.net.Uri
import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.mars_1_drilling.R
import com.example.mars_1_drilling.network.MarsPhoto
import com.example.mars_1_drilling.viewmodel.ConnectionStatus

@BindingAdapter ("imgUrl")
fun bindImgUrl(imageView: ImageView, imgUrl: String?){

    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
            imageView.load(imgUri){
                placeholder(R.drawable.loading_animation)
                error(R.drawable.ic_broken_image)
            }

    }
}

@BindingAdapter ("liveData")
fun bindData(recyclerView: RecyclerView, data: List<MarsPhoto>?){
    val adapter = recyclerView.adapter as GridAdapter
    adapter.submitList(data)
}


@BindingAdapter ("connectionStatus")
fun bindStatus(imageView: ImageView, status: ConnectionStatus?){
    when(status){
        ConnectionStatus.LOADING ->{
            imageView.visibility = View.VISIBLE
            imageView.setImageResource(R.drawable.loading_animation)
        }

        ConnectionStatus.ERROR ->{
            imageView.visibility = View.VISIBLE
            imageView.setImageResource(R.drawable.ic_broken_image)
        }

        ConnectionStatus.DONE ->{
            imageView.visibility = View.GONE

        }
    }
}




























