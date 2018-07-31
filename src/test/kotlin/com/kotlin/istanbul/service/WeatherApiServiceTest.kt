package com.kotlin.istanbul.service

import com.fasterxml.jackson.databind.ObjectMapper
import com.kotlin.istanbul.model.Weather
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.client.MockRestServiceServer
import org.springframework.test.web.client.match.MockRestRequestMatchers
import org.springframework.test.web.client.response.MockRestResponseCreators
import java.time.Instant


@RunWith(SpringRunner::class)
@RestClientTest(WeatherApiService::class)
class WeatherApiServiceTest {

    @Autowired
    private lateinit var objectMapper: ObjectMapper

    @Autowired
    private lateinit var weatherApiService: WeatherApiService

    @Autowired
    private lateinit var mockRestServiceServer: MockRestServiceServer


    @Test
    fun `It should fetch data from Weather API Successfully`() {
        //Given
        val token = "ae9977d920633f90e804da73d54e52b7"
        val weather = Weather(323786, "Ankara", 305.64, 801, "02d", Instant.now())
        val body = objectMapper.toJson(weather)
        mockRestServiceServer.expect(MockRestRequestMatchers.requestTo("https://api.openweathermap.org/data/2.5/weather?q=Ankara,TR&appId=$token"))
                .andRespond(MockRestResponseCreators.withSuccess(body, MediaType.APPLICATION_JSON_UTF8))
        //When
        val response = weatherApiService.getWeatherInformation("Ankara", "TR")
        //Then
        assertThat(response).isSameAs(weather)
    }


}

fun ObjectMapper.toJson(body: Any) = this.writeValueAsString(body)

