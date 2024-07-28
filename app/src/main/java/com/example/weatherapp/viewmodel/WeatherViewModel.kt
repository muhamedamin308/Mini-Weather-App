package com.example.weatherapp.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.weatherapp.repo.WeatherRepository
import com.example.weatherapp.util.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @author Muhamed Amin Hassan on 27,July,2024
 * @see <a href="https://github.com/muhamedamin308">Muhamed's Github</a>,
 * Egypt, Cairo.
 */
@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val repository: WeatherRepository
) : ViewModel() {

    fun getWeather(city: String) = liveData {
        try {
            val weather = repository.getWeather(city)
            if (weather != null) {
                emit(weather)
            } else {
                Log.d(Constants.Tag, "Failed to fetch weather")
                emit(null)
            }
        } catch (e: Exception) {
            Log.e(Constants.Tag, "Error fetching weather data: ${e.message}")
            emit(null)
        }
    }
}