package com.github.akhilsunilkumar.springbootreactivecouchbase.infrastructure.repository.service

import com.couchbase.client.java.ReactiveBucket
import com.github.akhilsunilkumar.springbootreactivecouchbase.IntegrationTestSpec
import com.github.akhilsunilkumar.springbootreactivecouchbase.entities.domain.Movie
import com.github.akhilsunilkumar.springbootreactivecouchbase.entities.interfaces.repository.MovieRepository
import io.kotest.core.spec.Spec
import io.kotest.matchers.nulls.shouldBeNull
import reactor.test.StepVerifier

class MovieRepositoryTest (
    private val movieRepository: MovieRepository,
    private val bucket: ReactiveBucket
): IntegrationTestSpec() {
    val movieData = hashMapOf(
        "m1" to Movie(name = "Avengers1", year = "2012"),
        "m2" to Movie(name = "Avengers2", year = "2014"),
        "m3" to Movie(name = "Avengers3", year = "2016"),
    )

    var idsToBeRemoved = mutableListOf<String>()

    init {
        Given("some movie data") {
            val movieData = hashMapOf(
                "m1" to Movie(name = "Avengers1", year = "2012"),
                "m2" to Movie(name = "Avengers2", year = "2014"),
                "m3" to Movie(name = "Avengers3", year = "2016"),
            )
            When("Find All Movies is called") {
                val allMovies = movieRepository.findAll()
                Then("All movies are returned") {
                    StepVerifier.create(allMovies)
                        .shouldBeNull()
                }
            }
        }
    }

    override suspend fun beforeSpec(spec: Spec) {
        super.beforeSpec(spec)
        movieData.map {
            bucket.defaultCollection().upsert(it.key, it.value)
                .block()
            idsToBeRemoved.add(it.key)
        }
    }

    override suspend fun afterSpec(spec: Spec) {
        super.afterSpec(spec)
        idsToBeRemoved.map {
            bucket.defaultCollection().remove(it)
                .block()
        }
    }
}