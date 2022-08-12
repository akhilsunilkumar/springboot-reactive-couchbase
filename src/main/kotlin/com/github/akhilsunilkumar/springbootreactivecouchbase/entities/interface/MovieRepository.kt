package com.github.akhilsunilkumar.springbootreactivecouchbase.entities.`interface`

import com.github.akhilsunilkumar.springbootreactivecouchbase.entities.domain.Movie
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface MovieRepository {

    //Returns all the movies in the DB
    fun findAll(): Flux<Movie>

    //Insert a new Movie
    fun insert(movie: Movie): Mono<Void>

}