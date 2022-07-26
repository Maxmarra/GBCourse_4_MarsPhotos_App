package com.example.android.marsphotos.repository

import com.example.android.marsphotos.database.MovieDatabase
import com.example.android.marsphotos.network.API_KEY
import com.example.android.marsphotos.network.MarsApi
import com.example.android.marsphotos.network.asDatabaseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MoviesRepository(private val database: MovieDatabase) {

    suspend fun refreshMovies() {
        withContext(Dispatchers.IO) {
            val movieList = MarsApi.retrofitService.getPopularMovies(apiKey = API_KEY)

            database.movieDao.insertAllMovies(movieList.asDatabaseModel())
        }
    }
}