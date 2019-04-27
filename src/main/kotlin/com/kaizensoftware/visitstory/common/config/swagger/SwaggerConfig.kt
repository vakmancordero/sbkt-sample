package com.kaizensoftware.visitstory.common.config.swagger

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component

import springfox.documentation.swagger2.annotations.EnableSwagger2
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.spi.DocumentationType
import springfox.documentation.builders.*
import springfox.documentation.service.*

@Configuration
@EnableSwagger2
@ConfigurationProperties(prefix = "app.swagger")
class SwaggerConfig {

    lateinit var name: String
    lateinit var version: String
    lateinit var description: String

    lateinit var maintainerName: String
    lateinit var maintainerEmail: String
    lateinit var maintainerUrl: String

    @Bean
    fun vsDocket() : Docket {
        return docket("VisitStory", "/.*")
    }

    private fun docket(title: String, path: String): Docket {
        return Docket(DocumentationType.SWAGGER_2)
                .groupName(title)

                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.regex(path))
                .build()

                .pathMapping("/")
                .apiInfo(info())
    }

    private fun info(): ApiInfo {

        return ApiInfoBuilder()
                .title(name)
                .description(description)
                .version(version)
                .contact(Contact(
                        maintainerName,
                        maintainerUrl,
                        maintainerEmail
                )).build()
    }

}

