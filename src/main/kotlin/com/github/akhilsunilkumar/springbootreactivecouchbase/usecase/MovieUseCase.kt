package com.github.akhilsunilkumar.springbootreactivecouchbase.usecase

import com.github.akhilsunilkumar.springbootreactivecouchbase.entities.domain.Movie
import com.github.akhilsunilkumar.springbootreactivecouchbase.entities.interfaces.repository.MovieRepository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

class MovieUseCase(
    private val movieRepository: MovieRepository
) {
    fun findAllMovies() : Flux<Movie> {
        return movieRepository.findAll()
    }

    fun insertMovie(movie: Movie): Mono<Void> {
        return movieRepository.insert(movie)
    }
}