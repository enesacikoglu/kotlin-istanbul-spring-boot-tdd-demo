package com.kotlin.istanbul.model

data class WeatherSummary(
        val country: String,
        val city: String,
        val code: Int?,
        val icon: String?,
        val temperature: Double?
) {
    constructor(country: String, city: String, weather: Weather?)
            : this(country, city, weather?.id, weather?.weatherIcon, weather?.temp)


    fun getFahrenheitTemperature(): String {
        val fahrenheitTemp = (this.temperature!! * 1.8) - 459.67
        return String.format("%4.2f", fahrenheitTemp)
    }


    fun getCelsiusTemperature(): String {
        val celsiusTemp = this.temperature!! - 273.15
        return String.format("%4.2f", celsiusTemp)
    }
}