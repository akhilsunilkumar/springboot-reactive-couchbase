package com.github.akhilsunilkumar.springbootreactivecouchbase.infrastructure.repository.service

import com.couchbase.client.java.ReactiveCluster
import com.fasterxml.jackson.databind.ObjectMapper
import com.github.akhilsunilkumar.springbootreactivecouchbase.entities.domain.Movie
import com.github.akhilsunilkumar.springbootreactivecouchbase.entities.`interface`.MovieRepository
import com.github.akhilsunilkumar.springbootreactivecouchbase.infrastructure.repository.config.RepositoryConfig
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Repository
class MovieRepositoryImpl(
    private val cluster: ReactiveCluster,
    private val repositoryConfig: RepositoryConfig,
    private val objectMapper: ObjectMapper
): MovieRepository {

    override fun findAll(): Flux<Movie> {
        TODO("Not yet implemented")
    }

    override fun insert(movie: Movie): Mono<Void> {
        TODO("Not yet implemented")
    }

}