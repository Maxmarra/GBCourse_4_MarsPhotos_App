package com.example.mars_1_drilling.network

import com.squareup.moshi.Json

data class MarsPhoto(
    val id: String,

    @Json(name = "img_src")
    val imgSrcUrl: String
)