package com.kotlin.istanbul.controller

import com.kotlin.istanbul.model.Weather
import com.kotlin.istanbul.service.WeatherApiService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class WeatherController {

    @Autowired
    private lateinit var weatherApiService: WeatherApiService

    @RequestMapping("/weather")
    fun get(): Weather? = weatherApiService.getWeatherInformation("Ankara", "TR");

}