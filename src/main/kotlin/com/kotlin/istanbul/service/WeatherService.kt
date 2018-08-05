package com.kotlin.istanbul.service

import com.kotlin.istanbul.constant.MessageKeyConstants
import com.kotlin.istanbul.exception.KotlinApiDomainNotFoundException
import com.kotlin.istanbul.model.WeatherDto
import com.kotlin.istanbul.repository.WeatherEntityRepository
import org.springframework.stereotype.Service

@Service
class WeatherService(val weatherEntityRepository: WeatherEntityRepository) {
    fun getWeather(cityName: String, countryCode: String): WeatherDto {
        val weatherEntity = weatherEntityRepository.findById(1L)
                .orElseThrow { throw KotlinApiDomainNotFoundException(MessageKeyConstants.MESSAGE_KEY_DOMAIN_NOT_FOUND) }
        return WeatherDto.toDto(weatherEntity)
    }

}