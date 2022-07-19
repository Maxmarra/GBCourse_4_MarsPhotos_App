package com.example.android.marsphotos

import android.util.Log
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.android.marsphotos.network.IMG_URL
import com.example.android.marsphotos.network.MovieDetail

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val combinedUrl = IMG_URL + imgUrl
        val finalUrl = combinedUrl.toUri().buildUpon().scheme("https").build()
        Log.d("IMAGEURL", "$combinedUrl")
        imgView.load(finalUrl) {
            placeholder(R.drawable.loading_animation)
            error(R.drawable.ic_broken_image)
        }
    }
}

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView,
                     data: List<MovieDetail>?) {
    val adapter = recyclerView.adapter as MovieGridAdapter
    adapter.submitList(data)
}