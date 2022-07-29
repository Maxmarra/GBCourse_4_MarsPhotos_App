package com.example.android.marsphotos.domain.repository

interface WeatherRepository {
    suspend fun getWeatherData(lat: Double, long: Double)

}