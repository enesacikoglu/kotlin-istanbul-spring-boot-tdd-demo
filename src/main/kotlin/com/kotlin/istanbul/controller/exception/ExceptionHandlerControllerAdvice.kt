package com.kotlin.istanbul.controller.exception

import com.kotlin.istanbul.exception.KotlinApiDomainNotFoundException
import com.kotlin.istanbul.exception.KotlinRestApiBusinessException
import com.kotlin.istanbul.model.error.ErrorDto
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.MessageSource
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.util.*
import javax.servlet.http.HttpServletRequest

@RestControllerAdvice
class ExceptionHandlerControllerAdvice(var messageSource: MessageSource) {

    private val logger: Logger = LoggerFactory.getLogger(ExceptionHandlerControllerAdvice::class.java)

    @ExceptionHandler(KotlinRestApiBusinessException::class)
    fun handleApiBusinessException(request: HttpServletRequest, kotlinRestApiBusinessException: KotlinRestApiBusinessException): ErrorDto {
        logger.debug("kotlinRestApiBusinessException : $kotlinRestApiBusinessException")
        val message = messageSource.getMessage(kotlinRestApiBusinessException.message, null, Locale.ENGLISH)
        return ErrorDto(HttpStatus.INTERNAL_SERVER_ERROR.reasonPhrase, HttpStatus.INTERNAL_SERVER_ERROR.value(), message, request.requestURI, request.method)

    }

    @ExceptionHandler(KotlinApiDomainNotFoundException::class)
    fun handleApiDomainNotFoundException(request: HttpServletRequest, kotlinApiDomainNotFoundException: KotlinApiDomainNotFoundException): ErrorDto {
        logger.debug("kotlinRestApiBusinessException : $kotlinApiDomainNotFoundException")
        val message = messageSource.getMessage(kotlinApiDomainNotFoundException.message, null, Locale.ENGLISH)
        return ErrorDto(HttpStatus.NOT_FOUND.reasonPhrase, HttpStatus.NOT_FOUND.value(), message, request.requestURI, request.method)
    }


}