package com.github.akhilsunilkumar.springbootreactivecouchbase.web.routes

import com.github.akhilsunilkumar.springbootreactivecouchbase.web.handler.MovieHandler
import org.springframework.core.io.ClassPathResource
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.router

class HttpRouter(
    private val movieHandler: MovieHandler
) {

    fun router() = router {
        "/api".nest {
            accept(MediaType.APPLICATION_JSON).nest {
                GET("/movies", movieHandler::findAll)
                POST("/movie", movieHandler::insert)
            }
        }
        resources("/**", ClassPathResource("static/"))
    }

}