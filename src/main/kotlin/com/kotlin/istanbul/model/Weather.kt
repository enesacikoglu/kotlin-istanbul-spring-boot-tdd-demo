package com.kotlin.istanbul.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.Instant

data class
Weather constructor(val id: Int,
                               val name: String,
                               var temp: Double,
                               var weatherId: Int?,
                               var weatherIcon: String?,
                               @JsonProperty("dt")val timestamp: Instant) {


    @JsonProperty("main")
    fun unPackMain(main: Map<String, Any>) {
        this.temp = main["temp"] as Double

    }

    @JsonProperty("weather")
    fun unPackWeather(weatherEntries: List<Map<String, Any>>) {
        val weather = weatherEntries.first()
        this.weatherId = weather["id"] as Int
        this.weatherIcon = weather["icon"] as String
    }
}
