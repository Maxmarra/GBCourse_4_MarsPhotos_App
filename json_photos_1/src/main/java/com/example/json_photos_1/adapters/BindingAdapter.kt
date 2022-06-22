package com.example.json_photos_1.adapters

import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.json_photos_1.R
import com.example.json_photos_1.network.Photo
import com.example.json_photos_1.viewmodel.ConnectionStatus

@BindingAdapter("imgUrl")
fun bindImage(imageView: ImageView, url:String?){
    url?.let {
        val uri = url.toUri().buildUpon().scheme("https").build()

        imageView.load(uri){
        }
    }
}

@BindingAdapter("liveData")
fun bindImage(recyclerView: RecyclerView, data:List<Photo>?){
    val adapter = recyclerView.adapter as PhotoGridAdapter
    adapter.submitList(data)
}

@BindingAdapter("connectionStatus")
fun bindStatus(imageView: ImageView, status:ConnectionStatus?){

    when(status){
        ConnectionStatus.LOADING -> {
            imageView.visibility = View.VISIBLE
            imageView.setImageResource(R.drawable.loading_animation)
        }

        ConnectionStatus.ERROR -> {
            imageView.visibility = View.VISIBLE
            imageView.setImageResource(R.drawable.ic_broken_image)
        }

        ConnectionStatus.DONE -> {
            imageView.visibility = View.GONE

        }
    }

}