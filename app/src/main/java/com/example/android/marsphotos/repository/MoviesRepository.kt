package com.example.android.marsphotos.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.android.marsphotos.database.MovieDatabase
import com.example.android.marsphotos.database.asDomainModelFromDb
import com.example.android.marsphotos.model.ModelMovie
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

    //
    val movies: LiveData<List<ModelMovie>> =
        Transformations.map(database.movieDao.getMovies()) {
            it.asDomainModelFromDb()
        }
}