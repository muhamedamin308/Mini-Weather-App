package com.example.weatherapp.repo

import com.example.weatherapp.model.WeatherResponse

/**
 * @author Muhamed Amin Hassan on 27,July,2024
 * @see <a href="https://github.com/muhamedamin308">Muhamed's Github</a>,
 * Egypt, Cairo.
 */
interface WeatherRepository {
    suspend fun getWeather(city: String): WeatherResponse?
}