package com.kotlin.istanbul

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinRestApiApplication

fun main(args: Array<String>) {
    runApplication<KotlinRestApiApplication>(*args)
}
