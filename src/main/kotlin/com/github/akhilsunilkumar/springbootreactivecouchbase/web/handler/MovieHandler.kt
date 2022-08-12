package com.github.akhilsunilkumar.springbootreactivecouchbase.web.handler

import com.github.akhilsunilkumar.springbootreactivecouchbase.application.service.MovieService
import com.github.akhilsunilkumar.springbootreactivecouchbase.entities.domain.Movie
import com.github.akhilsunilkumar.springbootreactivecouchbase.web.mapper.MovieMapper
import com.github.akhilsunilkumar.springbootreactivecouchbase.web.model.MovieRequest
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

@Component
class MovieHandler(
    private val movieService: MovieService
) {

    fun findAll(serviceRequest: ServerRequest): Mono<ServerResponse> {
        return ServerResponse.ok().body(movieService.findAllMovies(), Movie::class.java)
    }

    fun insert(serverRequest: ServerRequest): Mono<ServerResponse> {
        return serverRequest.bodyToMono(MovieRequest::class.java)
            .flatMap { movieService.insertMovie(MovieMapper.toMovie(it)) }
            .flatMap { ServerResponse.ok().build() }
    }

}