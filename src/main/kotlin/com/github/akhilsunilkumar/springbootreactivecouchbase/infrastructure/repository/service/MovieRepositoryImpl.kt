package com.github.akhilsunilkumar.springbootreactivecouchbase.infrastructure.repository.service

import com.couchbase.client.java.ReactiveCluster
import com.couchbase.client.java.json.JsonArray
import com.couchbase.client.java.json.JsonObject
import com.couchbase.client.java.query.QueryOptions
import com.fasterxml.jackson.databind.ObjectMapper
import com.github.akhilsunilkumar.springbootreactivecouchbase.entities.domain.Movie
import com.github.akhilsunilkumar.springbootreactivecouchbase.entities.`interface`.MovieRepository
import com.github.akhilsunilkumar.springbootreactivecouchbase.infrastructure.repository.config.RepositoryConfig
import com.github.akhilsunilkumar.springbootreactivecouchbase.infrastructure.repository.mapper.MovieMapper
import com.github.akhilsunilkumar.springbootreactivecouchbase.infrastructure.repository.model.MovieDTO
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.UUID

@Repository
class MovieRepositoryImpl(
    private val cluster: ReactiveCluster,
    private val repositoryConfig: RepositoryConfig,
    private val objectMapper: ObjectMapper
): MovieRepository {

    override fun findAll(): Flux<Movie> {
        return cluster.query(
            """
                select name, year from ${repositoryConfig.bucket}
            """.trimIndent(),
            QueryOptions.queryOptions()
                .maxParallelism(4)
        )
            .flatMapMany {
                it.rowsAsObject()
            }
            .map {
                objectMapper.readValue(it.toBytes(), MovieDTO::class.java)
            }
            .map {
                MovieMapper.toMovie(it)
            }
    }

    override fun insert(movie: Movie): Mono<Void> {
        val movieDTO = MovieMapper.fromMovie(movie)
        return cluster
            .bucket(repositoryConfig.bucket)
            .defaultCollection()
            .upsert(UUID.randomUUID().toString(),JsonObject.fromJson(objectMapper.writeValueAsBytes(movieDTO))).then()
    }

}