package com.example.android.marsphotos

import android.util.Log
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import coil.load
import com.example.android.marsphotos.network.IMG_URL

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