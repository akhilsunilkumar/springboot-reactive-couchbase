package com.github.akhilsunilkumar.springbootreactivecouchbase.web.config

import com.github.akhilsunilkumar.springbootreactivecouchbase.web.routes.HttpRouter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.config.EnableWebFlux
import org.springframework.web.reactive.config.WebFluxConfigurer
import org.springframework.web.reactive.function.server.RouterFunction

@Configuration
@EnableWebFlux
class WebModule: WebFluxConfigurer {

    @Bean
    fun router(httpRouter: HttpRouter): RouterFunction<*> {
        return httpRouter.router()
    }
}