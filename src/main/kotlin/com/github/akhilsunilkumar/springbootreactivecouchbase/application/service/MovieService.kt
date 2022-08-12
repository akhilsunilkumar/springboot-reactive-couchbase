package com.github.akhilsunilkumar.springbootreactivecouchbase.application.service

import com.github.akhilsunilkumar.springbootreactivecouchbase.entities.domain.Movie
import com.github.akhilsunilkumar.springbootreactivecouchbase.usecase.MovieUseCase
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Component
class MovieService(
    private val movieUseCase: MovieUseCase
) {
    fun findAllMovies(): Flux<Movie> {
        return movieUseCase.findAllMovies()
    }
     fun insertMovie(movie: Movie): Mono<Void>{
         return movieUseCase.insertMovie(movie)
     }
}