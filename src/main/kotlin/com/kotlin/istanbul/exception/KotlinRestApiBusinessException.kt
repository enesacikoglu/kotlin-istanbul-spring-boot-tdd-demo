package com.kotlin.istanbul.exception

open class KotlinRestApiBusinessException(override val message: String) : RuntimeException(message)