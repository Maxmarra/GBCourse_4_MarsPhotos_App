package com.example.android.marsphotos.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.marsphotos.model.ModelMovie
import com.example.android.marsphotos.network.API_KEY
import com.example.android.marsphotos.network.MarsApi
import com.example.android.marsphotos.network.NetworkMovie
import com.example.android.marsphotos.network.asDomainModel
import kotlinx.coroutines.launch

enum class MovieApiStatus { LOADING, ERROR, DONE }

class OverviewViewModel : ViewModel() {

    private val _status = MutableLiveData<MovieApiStatus>()
    val status: LiveData<MovieApiStatus> = _status

    private val _movies = MutableLiveData<List<ModelMovie>>()
    val movies: LiveData<List<ModelMovie>> = _movies

    init {
        getMovies()
    }

    private fun getMovies() {
        _status.value = MovieApiStatus.LOADING
        viewModelScope.launch {
            try {
                val movieList = MarsApi.retrofitService.getPopularMovies(apiKey = API_KEY)
                //грузим напрямую из интернета
                _movies.postValue(movieList.asDomainModel())
                _status.value = MovieApiStatus.DONE

            } catch (e: Exception) {
                _status.value = MovieApiStatus.ERROR
                _movies.value = listOf()
            }
        }
    }
}
