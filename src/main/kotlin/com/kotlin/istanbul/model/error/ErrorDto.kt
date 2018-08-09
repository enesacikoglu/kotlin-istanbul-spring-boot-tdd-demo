package com.kotlin.istanbul.model.error

data class ErrorDto(val title: String, val status: Int, val detail: String, val requestUri: String, val requestMethod: String)