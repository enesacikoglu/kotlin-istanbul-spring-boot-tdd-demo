package com.kotlin.istanbul.service

import com.kotlin.istanbul.constant.WheatherAppConstants
import com.kotlin.istanbul.model.Weather
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.http.HttpEntity
import org.springframework.http.HttpMethod
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForEntity

@Service
class WeatherApiService {


    private var restTemplate: RestTemplate


    constructor(restTemplateBuilder: RestTemplateBuilder) {
        this.restTemplate = restTemplateBuilder
                .rootUri(WheatherAppConstants.WHEATHER_APP_URL)
                .setConnectTimeout(WheatherAppConstants.API_CONN_TIMEOT)
                .setReadTimeout(WheatherAppConstants.API_READ_TIMEOUT)
                .build()
    }

    fun getWeatherInformation(city: String, countryCode: String): Weather? = restTemplate.getForEntity("/weather?q={city},{countryCode}&appId={appId}",
            Weather::class.java, city, countryCode, WheatherAppConstants.TOKEN)
            .body

}
