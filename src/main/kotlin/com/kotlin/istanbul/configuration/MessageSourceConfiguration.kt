package com.kotlin.istanbul.configuration

import org.springframework.context.MessageSource
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.support.ResourceBundleMessageSource

@Configuration
class MessageSourceConfiguration {

    @Bean
    fun messageSource(): MessageSource {
        val resourceBundleMessageSource = ResourceBundleMessageSource()
        resourceBundleMessageSource.setBasenames("messages/messages")
        resourceBundleMessageSource.setDefaultEncoding("UTF-8")
        return resourceBundleMessageSource
    }

}