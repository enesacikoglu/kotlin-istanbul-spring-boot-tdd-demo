package com.kotlin.istanbul.repository

import com.kotlin.istanbul.domain.WeatherEntity
import org.springframework.data.repository.CrudRepository
import java.util.*


interface WeatherEntityRepository : CrudRepository<WeatherEntity, Long> {
    fun findByCityAndCountryCode(city: String, countryCode: String): Optional<WeatherEntity>
}