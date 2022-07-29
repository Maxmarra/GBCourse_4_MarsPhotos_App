package com.example.android.marsphotos.overview

import android.content.pm.PackageManager
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.marsphotos.data.location.DefaultLocationTracker
import com.example.android.marsphotos.domain.WeatherUnited
import com.example.android.marsphotos.domain.location.LocationTracker
import com.example.android.marsphotos.domain.repository.WeatherRepository
import com.example.android.marsphotos.network.APP_KEY
import com.example.android.marsphotos.network.DataList
import com.example.android.marsphotos.network.WeatherApiObject
import com.example.android.marsphotos.network.asDomainModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

enum class WeatherApiStatus { LOADING, ERROR, DONE }


@HiltViewModel
class OverviewViewModel @Inject constructor(
    private val repository: WeatherRepository,
    private val locationTracker: LocationTracker
) : ViewModel() {

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
                locationTracker.getCurrentLocation()?.let{
                    _weathers.value = repository.getWeatherData(it.latitude, it.longitude)


                }


                Log.d("POBEDA", "${_weathers.value!!.size}")
                _status.value = WeatherApiStatus.DONE

            } catch (e: Exception) {
                _status.value = WeatherApiStatus.ERROR
                Log.e("HUI", "${e.message}")
                _weathers.value = listOf()
            }
        }
    }





}
