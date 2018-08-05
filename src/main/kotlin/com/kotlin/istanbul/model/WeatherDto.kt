package com.kotlin.istanbul.model

import com.kotlin.istanbul.domain.WeatherEntity

data class WeatherDto(var city: String, var countyCode: String, var id: Long) {

    companion object {
        fun toDto(weatherEntity: WeatherEntity): WeatherDto = WeatherDto(weatherEntity.city, weatherEntity.countryCode, weatherEntity.id!!)
    }
}