package com.example.android.marsphotos.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.marsphotos.network.API_KEY
import com.example.android.marsphotos.network.MarsApi
import com.example.android.marsphotos.network.MarsApiService
import com.example.android.marsphotos.network.MovieDetail
import kotlinx.coroutines.launch

class OverviewViewModel : ViewModel() {

    private val _status = MutableLiveData<String>()
    val status: LiveData<String> = _status

    private val _movies = MutableLiveData<MovieDetail>()
    val movies: LiveData<MovieDetail> = _movies

    init {
        getMarsPhotos()
    }

    private fun getMarsPhotos() {
        viewModelScope.launch {
            try {
                _movies.value = MarsApi.retrofitService.getPopularMovies(apiKey = API_KEY).popularMovies[2]
                _status.value = "   First Mars image URL : ${_movies.value!!.posterPath}"
            } catch (e: Exception) {
                _status.value = "Failure: ${e.message}"
            }
        }
    }
}
