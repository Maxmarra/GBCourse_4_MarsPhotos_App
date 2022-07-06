package com.example.android.marsphotos.domain

import com.squareup.moshi.Json

data class MarsPhotoDomain(
    val id: String,

    @Json(name = "img_src")
    val imgSrc:String
)