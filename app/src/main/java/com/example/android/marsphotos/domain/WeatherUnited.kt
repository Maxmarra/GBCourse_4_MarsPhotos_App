package com.example.android.marsphotos.domain

import com.example.android.marsphotos.network.Weather
import java.time.LocalDateTime


data class WeatherUnited (
    //val time: Long,
    val temperature: Double,
    //val feelsLike: Double,
    //val weather: List<Weather>,
    val weatherDescription: String,
    //val speed: Double
    //val dtTxt: String
    val dateTime:Long
)

