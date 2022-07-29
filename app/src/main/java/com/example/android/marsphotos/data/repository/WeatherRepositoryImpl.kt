package com.example.android.marsphotos.data.repository

import com.example.android.marsphotos.domain.repository.WeatherRepository
import com.example.android.marsphotos.network.WeatherApiService
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApiService
): WeatherRepository {

    override suspend fun getWeatherData(lat: Double, long: Double){}
}