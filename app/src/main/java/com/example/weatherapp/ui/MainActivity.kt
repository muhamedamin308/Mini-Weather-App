package com.example.weatherapp.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.weatherapp.databinding.ActivityMainBinding
import com.example.weatherapp.viewmodel.WeatherViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val weatherViewModel by viewModels<WeatherViewModel>()
    private lateinit var binding: ActivityMainBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            buttonFetch.setOnClickListener {
                val city = editTextCity1.text.toString()
                weatherViewModel.getWeather(city).observe(this@MainActivity) { weather ->
                    if (weather != null) {
                        Glide.with(this@MainActivity)
                            .load("https:${weather.current.condition.icon}")
                            .into(weatherStateImage)
                        tvWeatherCurrentTemp.text = weather.current.temp_c.toString() + "°C"
                        tvCountry.text = "Country: ${weather.location.country}"
                        tvCity.text = "City: ${weather.location.name}"
                        tvConditionName.text = weather.current.condition.text
                        tvCloudTemp.text = weather.current.cloud.toString() + "% Cloud"
                        tvLocalTime.text = weather.location.localtime
                    } else
                        Toast.makeText(this@MainActivity, "City not found", Toast.LENGTH_SHORT)
                            .show()
                }
            }
        }
    }
}