package com.kotlin.istanbul.controller

import com.kotlin.istanbul.domain.WeatherEntity
import com.kotlin.istanbul.model.WeatherDto
import com.kotlin.istanbul.service.WeatherService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

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

    @GetMapping("/{id}")
    fun getById(@PathVariable("id") id: Long): WeatherDto {
        return weatherService.findById(id)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun save(@RequestBody weatherDto: WeatherDto): Long {
        return weatherService.save(WeatherEntity(weatherDto.city, weatherDto.countryCode)).id
    }
}