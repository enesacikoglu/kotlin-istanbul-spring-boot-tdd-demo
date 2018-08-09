package com.kotlin.istanbul.exception

class KotlinApiDomainNotFoundException(override val message: String) : KotlinRestApiBusinessException(message)