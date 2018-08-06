package com.kotlin.istanbul.model.error

data class ErrorDto(var title: String, var status: Int, var detail: String, var requestUri: String, var requestMethod: String)