package com.kotlin.istanbul.configuration

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(classes = [ApiResource::class])
@EnableConfigurationProperties(ApiResource::class)
class ApiResourceTest {

    @Autowired
    private lateinit var apiResource: ApiResource;

    @Test
    fun `👻 it should get open weather api root 👻`() {
        //Arrange

        //Act
        val root = apiResource.root

        //Assert
        assertThat(root).isEqualTo("https://api.openweathermap.org/data/2.5")
    }
}