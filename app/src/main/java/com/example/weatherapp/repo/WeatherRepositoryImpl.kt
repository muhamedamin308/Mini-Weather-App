package com.example.weatherapp.repo

import android.util.Log
import com.example.weatherapp.model.WeatherResponse
import com.example.weatherapp.network.WeatherApiService
import com.example.weatherapp.util.Constants
import javax.inject.Inject

/**
 * @author Muhamed Amin Hassan on 27,July,2024
 * @see <a href="https://github.com/muhamedamin308">Muhamed's Github</a>,
 * Egypt, Cairo.
 */
class WeatherRepositoryImpl @Inject constructor(
    private val apiService: WeatherApiService
) : WeatherRepository {
    override suspend fun getWeather(city: String): WeatherResponse? {
        return try {
            val response = apiService.getWeather(city = city)
            Log.d(Constants.Tag, "Weather response: $response")
            response
        } catch (e: Exception) {
            Log.e(Constants.Tag, "Error fetching weather data: ${e.message}")
            null
        }
    }
}