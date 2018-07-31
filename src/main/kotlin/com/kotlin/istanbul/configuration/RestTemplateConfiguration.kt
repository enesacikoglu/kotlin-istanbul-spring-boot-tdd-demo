package com.kotlin.istanbul.configuration

import com.kotlin.istanbul.constant.WheatherAppConstants
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate

@Configuration
class RestTemplateConfiguration {

    @Bean
    fun restTemplate(restTemplateBuilder: RestTemplateBuilder): RestTemplate = restTemplateBuilder
            .rootUri(WheatherAppConstants.WHEATHER_APP_URL)
            .setConnectTimeout(WheatherAppConstants.API_CONN_TIMEOT)
            .setReadTimeout(WheatherAppConstants.API_READ_TIMEOUT)
            .build()

}