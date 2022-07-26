package com.example.android.marsphotos.overview

import android.app.Application
import androidx.lifecycle.*
import com.example.android.marsphotos.database.getDatabase
import com.example.android.marsphotos.model.ModelMovie
import com.example.android.marsphotos.network.API_KEY
import com.example.android.marsphotos.network.MarsApi
import com.example.android.marsphotos.network.NetworkMovie
import com.example.android.marsphotos.network.asDomainModel
import com.example.android.marsphotos.repository.MoviesRepository
import kotlinx.coroutines.launch

enum class MovieApiStatus { LOADING, ERROR, DONE }

class OverviewViewModel(application: Application) : AndroidViewModel(application) {

    private val moviesRepository = MoviesRepository(getDatabase(application))

    private val _status = MutableLiveData<MovieApiStatus>()
    val status: LiveData<MovieApiStatus> = _status

    //больше не нужны, действуем через репозиторий
//    private val _movies = MutableLiveData<List<ModelMovie>>()
//    val movies: LiveData<List<ModelMovie>> = _movies

    init {
        refreshDataFromRepository()

    }

    //то что принимаем в ресайклере во fragment_overview
    val movieList = moviesRepository.movies

    private fun refreshDataFromRepository() {
        _status.value = MovieApiStatus.LOADING
        viewModelScope.launch {
            try {

                moviesRepository.refreshMovies()

                _status.value = MovieApiStatus.DONE

            } catch (e: Exception) {
                _status.value = MovieApiStatus.ERROR
                //_movies.value = listOf()
            }
        }
    }
}
