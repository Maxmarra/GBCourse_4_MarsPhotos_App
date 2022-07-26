package com.example.android.marsphotos.repository

import com.example.android.marsphotos.network.API_KEY
import com.example.android.marsphotos.network.MarsApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MoviesRepository {

    suspend fun refreshVideos() {
        withContext(Dispatchers.IO) {
            val movieList = MarsApi.retrofitService.getPopularMovies(apiKey = API_KEY)
        }
    }
}