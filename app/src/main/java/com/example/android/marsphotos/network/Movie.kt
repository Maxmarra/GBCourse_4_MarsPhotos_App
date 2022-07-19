package com.example.android.marsphotos.network

import com.squareup.moshi.Json

data class Movie(
    @Json(name = "results")
    val popularMovies: List<MovieDetail>

)
data class MovieDetail(
    val title: String,
    @Json(name = "poster_path")
    val posterPath: String

)




