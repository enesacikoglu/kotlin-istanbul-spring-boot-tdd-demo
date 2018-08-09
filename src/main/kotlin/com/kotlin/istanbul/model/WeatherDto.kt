package com.kotlin.istanbul.model

import com.kotlin.istanbul.domain.WeatherEntity

data class WeatherDto(val city: String, val countryCode: String, val id: Long) {

    companion object {
        fun toDto(weatherEntity: WeatherEntity): WeatherDto = WeatherDto(weatherEntity.city, weatherEntity.countryCode, weatherEntity.id!!)

    }
}