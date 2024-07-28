package com.example.weatherapp.network

import com.example.weatherapp.model.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author Muhamed Amin Hassan on 27,July,2024
 * @see <a href="https://github.com/muhamedamin308">Muhamed's Github</a>,
 * Egypt, Cairo.
 */
interface WeatherApiService {
    @GET("current.json")
    suspend fun getWeather(
        @Query("key") apiKey: String = "{YOUR_API_KEY}",
        @Query("q") city: String,
        @Query("aqi") aqi: String = "no"
    ): WeatherResponse
}