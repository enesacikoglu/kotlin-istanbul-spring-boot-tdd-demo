package com.kotlin.istanbul.service

import com.kotlin.istanbul.constant.MessageKeyConstants
import com.kotlin.istanbul.domain.WeatherEntity
import com.kotlin.istanbul.exception.KotlinApiDomainNotFoundException
import com.kotlin.istanbul.model.WeatherDto
import com.kotlin.istanbul.repository.WeatherEntityRepository
import org.springframework.stereotype.Service

@Service
class WeatherService(val weatherEntityRepository: WeatherEntityRepository) {

    fun getWeather(cityName: String, countryCode: String): WeatherDto {
        val weatherEntity = weatherEntityRepository.findByCityAndCountryCode(cityName, countryCode)
                .orElseThrow { throw KotlinApiDomainNotFoundException(MessageKeyConstants.MESSAGE_KEY_DOMAIN_NOT_FOUND) }
        return WeatherDto.toDto(weatherEntity)
    }

    fun findById(id: Long): WeatherDto {
        val weatherEntity = weatherEntityRepository.findById(id)
                .orElseThrow { throw KotlinApiDomainNotFoundException(MessageKeyConstants.MESSAGE_KEY_DOMAIN_NOT_FOUND) }
        return WeatherDto.toDto(weatherEntity)
    }

    fun save(weatherEntity: WeatherEntity): WeatherDto {
        val savedEntity = weatherEntityRepository.save(weatherEntity)
        return WeatherDto.toDto(savedEntity)
    }

}
