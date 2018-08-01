package com.kotlin.istanbul.service

import com.fasterxml.jackson.databind.ObjectMapper
import com.kotlin.istanbul.configuration.ApiResource
import com.kotlin.istanbul.model.Weather
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.given
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.client.ExpectedCount
import org.springframework.test.web.client.MockRestServiceServer
import org.springframework.test.web.client.match.MockRestRequestMatchers
import org.springframework.test.web.client.response.MockRestResponseCreators


@RunWith(SpringRunner::class)
@RestClientTest(WeatherApiService::class)
class WeatherApiServiceTest {

    @Autowired
    private lateinit var objectMapper: ObjectMapper

    @Autowired
    private lateinit var weatherApiService: WeatherApiService

    @Autowired
    private lateinit var mockRestServiceServer: MockRestServiceServer

    @MockBean
    private lateinit var apiResource: ApiResource

    @Before
    fun setup(){
        given(apiResource.root).willReturn("https://api.openweathermap.org/data/2.5")
    }


    @Test
    fun `It Should Fetch Data From API Successfully 👍`() {
        //Given
        val token = "ae9977d920633f90e804da73d54e52b7"
        val body = "{\n" +
                "  \"weather\": [\n" +
                "    {\n" +
                "      \"id\": 300,\n" +
                "      \"icon\": \"09d\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"main\": {\n" +
                "    \"temp\": 280.32\n" +
                "  },\n" +
                "  \"dt\": 1485789600,\n" +
                "  \"id\": 2643743,\n" +
                "  \"name\": \"London\"\n" +
                "}"
        val weather = objectMapper.readValue(body, Weather::class.java)
        mockRestServiceServer
                .expect(ExpectedCount.once(), MockRestRequestMatchers.requestTo("/weather?q=Ankara,TR&appId=$token"))
                .andExpect { request -> request.method!!.matches("GET") }
                .andRespond(MockRestResponseCreators.withSuccess(body, MediaType.APPLICATION_JSON))
        //When
        val response = weatherApiService.getWeatherInformation("Ankara", "TR")
        //Then
        this.mockRestServiceServer.verify()
        assertThat(response).isEqualToComparingFieldByField(weather)
    }


}

fun ObjectMapper.toJson(body: Any) = this.writeValueAsString(body)

