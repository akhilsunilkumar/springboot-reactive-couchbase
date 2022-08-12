package com.github.akhilsunilkumar.springbootreactivecouchbase.web.mapper

import com.github.akhilsunilkumar.springbootreactivecouchbase.entities.domain.Movie
import com.github.akhilsunilkumar.springbootreactivecouchbase.web.model.MovieRequest

object MovieMapper {
    fun toMovie(movieRequest: MovieRequest): Movie {
        return Movie(
            name = movieRequest.name,
            year = movieRequest.year
        )
    }
}