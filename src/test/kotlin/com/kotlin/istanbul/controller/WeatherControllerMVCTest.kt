package com.kotlin.istanbul.controller

import com.kotlin.istanbul.model.Weather
import com.kotlin.istanbul.service.WeatherApiService
import org.hamcrest.CoreMatchers
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.given
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import java.time.Instant

@RunWith(SpringRunner::class)
@WebMvcTest(WeatherController::class)
class WeatherControllerMVCTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockBean
    private lateinit var weatherApiService: WeatherApiService

    @Test
    fun `It Should Get Weather By City Name And Country Code 👍`() {
        //Given
        var weather = Weather(1, "Ankara", 120.01, 61, "Icon", Instant.now())

        given(weatherApiService.getWeatherInformation("Ankara", "TR"))
                .willReturn(weather)

        //When
        val result=mockMvc.perform(MockMvcRequestBuilders.get("/weathers?city=Ankara&countryCode=TR"))
        //Then
        result.andExpect(MockMvcResultMatchers.status().is2xxSuccessful)
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", CoreMatchers.`is`(CoreMatchers.equalTo(1))))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", CoreMatchers.`is`(CoreMatchers.equalTo("Ankara"))))
                .andExpect(MockMvcResultMatchers.jsonPath("$.temp", CoreMatchers.`is`(CoreMatchers.equalTo(120.01))))
                .andExpect(MockMvcResultMatchers.jsonPath("$.weatherId", CoreMatchers.`is`(CoreMatchers.equalTo(61))))
                .andExpect(MockMvcResultMatchers.jsonPath("$.weatherIcon", CoreMatchers.`is`(CoreMatchers.equalTo("Icon"))))
    }



}