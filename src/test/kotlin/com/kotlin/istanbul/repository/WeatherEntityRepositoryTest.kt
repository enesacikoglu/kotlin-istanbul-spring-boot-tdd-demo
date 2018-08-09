package com.kotlin.istanbul.repository

import com.kotlin.istanbul.domain.WeatherEntity
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@DataJpaTest
class WeatherEntityRepositoryTest {

    @Autowired
    private lateinit var testEntityManager: TestEntityManager

    @Autowired
    private lateinit var weatherEntityRepository: WeatherEntityRepository


    @Test
    fun `🙆 it should get weather with city and country code 🙆`() {
        //Arrange
        val weatherEntity = WeatherEntity("Istanbul", "TR")

        testEntityManager.persist(weatherEntity)

        //Act
        val optionalWeatherEntity = weatherEntityRepository.findByCityAndCountryCode("Istanbul", "TR")

        //Assert
        assertThat(optionalWeatherEntity).isPresent
        assertThat(optionalWeatherEntity.get().city).isEqualTo("Istanbul")
        assertThat(optionalWeatherEntity.get().countryCode).isEqualTo("TR")
    }
}