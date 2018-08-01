package com.kotlin.istanbul.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class WeatherEntity(
        val city: String = "",
        val countryCode: String = "",
        @Id @GeneratedValue val id: Long? = null
)