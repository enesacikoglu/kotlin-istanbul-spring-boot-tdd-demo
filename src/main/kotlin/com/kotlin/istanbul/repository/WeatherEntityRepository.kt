package com.kotlin.istanbul.repository

import com.kotlin.istanbul.domain.WeatherEntity
import org.springframework.data.repository.CrudRepository


interface WeatherEntityRepository : CrudRepository<WeatherEntity,Long>