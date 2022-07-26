package com.example.android.marsphotos

import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.android.marsphotos.model.ModelMovie
import com.example.android.marsphotos.network.IMG_URL
import com.example.android.marsphotos.network.NetworkMovie
import com.example.android.marsphotos.overview.MovieApiStatus

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
                     data: List<ModelMovie>?) {
    val adapter = recyclerView.adapter as MovieGridAdapter
    adapter.submitList(data)
}

@BindingAdapter("movieApiStatus")
fun bindStatus(statusImageView: ImageView,
               status: MovieApiStatus?) {

    when (status) {
        MovieApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        MovieApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
        MovieApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }else -> { }
    }
}
























