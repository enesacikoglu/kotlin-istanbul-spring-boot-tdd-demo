package com.kotlin.istanbul.controller

import com.kotlin.istanbul.model.Weather
import com.kotlin.istanbul.service.WeatherApiService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/weathers")
class WeatherController {

    @Autowired
    private lateinit var weatherApiService: WeatherApiService

    /*TODO: make nulllable countryCode to show default required false action*/
    @GetMapping
    fun get(@RequestParam(name = "city") city: String,
            @RequestParam(name = "countryCode" ) countryCode: String): Weather? {
        return weatherApiService.getWeatherInformation(city = city, countryCode = countryCode)
    }

}