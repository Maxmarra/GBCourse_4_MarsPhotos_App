package com.example.android.marsphotos.overview

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.marsphotos.domain.WeatherUnited
import com.example.android.marsphotos.network.APP_KEY
import com.example.android.marsphotos.network.WeatherApiObject
import com.example.android.marsphotos.network.asDomainModel
import kotlinx.coroutines.launch

enum class WeatherApiStatus { LOADING, ERROR, DONE }

class OverviewViewModel : ViewModel() {

    private val _status = MutableLiveData<WeatherApiStatus>()
    val status: LiveData<WeatherApiStatus> = _status

    private val _weathers = MutableLiveData<List<WeatherUnited>>()
    val weather: LiveData<List<WeatherUnited>> = _weathers

    init {
        getWeather()
    }

    private fun getWeather() {
        _status.value = WeatherApiStatus.LOADING
        viewModelScope.launch {
            try {
                _weathers.value = WeatherApiObject.retrofitService.getWeatherData(45.025,37.25, APP_KEY).asDomainModel()
                Log.d("Winther", "FUUUUUUUUUUUUUUCK - ${_weathers.value}")
                _status.value = WeatherApiStatus.DONE

            } catch (e: Exception) {
                _status.value = WeatherApiStatus.ERROR
                _weathers.value = listOf()
            }
        }
    }
}
