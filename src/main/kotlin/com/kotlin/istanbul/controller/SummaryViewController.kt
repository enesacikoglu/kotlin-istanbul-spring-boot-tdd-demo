package com.kotlin.istanbul.controller

import com.kotlin.istanbul.domain.WeatherEntity
import com.kotlin.istanbul.model.WeatherSummary
import com.kotlin.istanbul.repository.WeatherEntityRepository
import com.kotlin.istanbul.service.WeatherApiService
import org.omg.CORBA.Object
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.servlet.ModelAndView


@Controller
class SummaryViewController(val weatherApiService: WeatherApiService,
                            val weatherEntityRepository: WeatherEntityRepository) {


    @GetMapping(value = ["/dashboard"])
    fun summaryView(model: Map<String, Object>): ModelAndView {
        val map = mapOf("summary" to getSummaries())
        return ModelAndView("summary", map)
    }

    private fun getSummaries(): List<WeatherSummary> =
            weatherEntityRepository.findAll()
                    .map(this::createWeatherSummary)

    private fun createWeatherSummary(weatherEntity: WeatherEntity): WeatherSummary {
        val weather = weatherApiService.getWeatherInformation(weatherEntity.city, weatherEntity.countryCode)
        return WeatherSummary(weatherEntity.countryCode, weatherEntity.city, weather)
    }

}