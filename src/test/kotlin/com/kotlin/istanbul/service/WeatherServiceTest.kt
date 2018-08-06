package com.kotlin.istanbul.service

import com.kotlin.istanbul.domain.WeatherEntity
import com.kotlin.istanbul.exception.KotlinApiDomainNotFoundException
import com.kotlin.istanbul.repository.WeatherEntityRepository
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.catchThrowable
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.given
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import java.util.*

@RunWith(MockitoJUnitRunner::class)
class WeatherServiceTest {

    @InjectMocks
    private lateinit var weatherService: WeatherService

    @Mock
    private lateinit var weatherEntityRepository: WeatherEntityRepository


    @Test
    fun `🙈 it should get weather of city with given name and code 🙈`() {
        //Arrange

        val weatherEntity = WeatherEntity("Istanbul", "TR", 1L)
        given(weatherEntityRepository.findByCityAndCountryCode("Istanbul", "TR"))
                .willReturn(Optional.ofNullable(weatherEntity))

        //Act
        val weatherDto = weatherService.getWeather("Istanbul", "TR")

        //Assert
        assertThat(weatherDto).isNotNull
        assertThat(weatherDto).isSameAs(weatherDto)
    }

    @Test
    fun `😓 it should throw domain not found exception when weather not found 😓`() {
        //Arrange

        given(weatherEntityRepository.findByCityAndCountryCode("Istanbul", "TR"))
                .willReturn(Optional.empty())

        //Act
        val throwable = catchThrowable { weatherService.getWeather("Istanbul", "TR") }

        //Assert
        assertThat(throwable).isNotNull()
        assertThat(throwable).isInstanceOf(KotlinApiDomainNotFoundException::class.java)
        assertThat(throwable.message).isEqualTo("weather.not.found.exception")
    }
}