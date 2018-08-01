package com.kotlin.istanbul.service

import com.kotlin.istanbul.configuration.ApiResource
import com.kotlin.istanbul.constant.WheatherAppConstants
import com.kotlin.istanbul.model.Weather
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.UriComponentsBuilder

@Service
class WeatherApiService {


    private var restTemplate: RestTemplate


    constructor(restTemplateBuilder: RestTemplateBuilder,apiResource: ApiResource) {
        this.restTemplate = restTemplateBuilder
                .rootUri(apiResource.root)
                .build()
    }

    fun getWeatherInformation(city: String, countryCode: String): Weather? {
        val uriString = UriComponentsBuilder.fromPath("/weather?q={city},{countryCode}&appId={appId}")
                .buildAndExpand(city, countryCode, WheatherAppConstants.TOKEN)
                .toUriString()

        return restTemplate.getForEntity(uriString,
                Weather::class.java)
                .body
    }

}
