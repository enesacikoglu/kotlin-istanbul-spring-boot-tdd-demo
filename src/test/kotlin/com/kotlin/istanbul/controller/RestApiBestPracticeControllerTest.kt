package com.kotlin.istanbul.controller

import com.kotlin.istanbul.service.WeatherService
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc

@RunWith(SpringRunner::class)
@WebMvcTest(RestApiBestPracticeController::class)
class RestApiBestPracticeControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockBean
    private lateinit var weatherService: WeatherService

    @Test
    fun `It Should Get Weather Of City When City Name And Code Given`() {
        //Arrange

        //Act

        //Assert
    }
}