package com.kotlin.istanbul.controller

import com.kotlin.istanbul.model.WeatherDto
import com.kotlin.istanbul.service.WeatherService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/rest/v1/weathers")
class RestApiBestPracticeController {

    @Autowired
    private lateinit var weatherService: WeatherService

    @GetMapping
    fun get(@RequestParam(name = "city") city: String,
            @RequestParam(name = "countryCode") countryCode: String): WeatherDto {
        return weatherService.getWeather(city, countryCode)
    }
}