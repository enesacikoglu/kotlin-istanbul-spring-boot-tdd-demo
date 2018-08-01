package com.kotlin.istanbul

import com.kotlin.istanbul.domain.WeatherEntity
import com.kotlin.istanbul.repository.WeatherEntityRepository
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.context.support.beans
import java.util.stream.Stream

@SpringBootApplication
class KotlinRestApiApplication

fun main(args: Array<String>) {

    SpringApplicationBuilder()
            .sources(KotlinRestApiApplication::class.java)
            .initializers(beans())
            .run(*args)
}

fun beans() = beans {
    bean {
        val repository = ref<WeatherEntityRepository>()
        Stream.of("London,uk", "Ankara,tr", "Berlin,de")
                .map { it.split(",") }
                .forEach { tpl -> repository.save(WeatherEntity(tpl[0], tpl[1])) }
        repository.findAll().forEach(::println)
    }
}
