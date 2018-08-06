package com.kotlin.istanbul.controller

import com.kotlin.istanbul.model.WeatherDto
import com.kotlin.istanbul.service.WeatherService
import org.hamcrest.CoreMatchers
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.given
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@RunWith(SpringRunner::class)
@WebMvcTest(RestApiBestPracticeController::class)
class RestApiBestPracticeControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockBean
    private lateinit var weatherService: WeatherService

    @Test
    fun `💯 It Should Get Weather Of City When City Name And Code Given 💯`() {
        //Arrange
        val requestBuilder = MockMvcRequestBuilders
                .get("/api/rest/v1/weathers?city=Istanbul&countryCode=TR")
                .accept(MediaType.APPLICATION_JSON)

        given(weatherService.getWeather("Istanbul", "TR"))
                .willReturn(WeatherDto("Istanbul", "TR", 1L))

        //Act
        val resultActions = mockMvc.perform(requestBuilder)

        //Assert
        resultActions.andExpect((MockMvcResultMatchers.status().is2xxSuccessful))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", CoreMatchers.`is`(CoreMatchers.equalTo(1))))
                .andExpect(MockMvcResultMatchers.jsonPath("$.city", CoreMatchers.`is`(CoreMatchers.equalTo("Istanbul"))))
                .andExpect(MockMvcResultMatchers.jsonPath("$.countryCode", CoreMatchers.`is`(CoreMatchers.equalTo("TR"))))
    }
}