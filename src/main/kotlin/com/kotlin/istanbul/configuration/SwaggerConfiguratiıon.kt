package com.kotlin.istanbul.configuration

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2
import java.util.*

@Configuration
@EnableSwagger2
class SwaggerConfiguratiıon(
        @Value("\${swagger.host.url}")
        var host: String,
        @Value("\${swagger.host.path}")
        var path: String) {

    fun api(): Docket {
        return Docket(DocumentationType.SWAGGER_2).host(host).pathMapping(path)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.kotlin.istanbul.controller"))
                .paths(PathSelectors.any())
                .build()
                .protocols(HashSet(Arrays.asList("https", "http")))
    }
}