package com.github.akhilsunilkumar.springbootreactivecouchbase.infrastructure.repository.mapper

import com.github.akhilsunilkumar.springbootreactivecouchbase.entities.domain.Movie
import com.github.akhilsunilkumar.springbootreactivecouchbase.infrastructure.repository.model.MovieDTO

object MovieMapper {

    fun toMovie(movieDTO: MovieDTO): Movie{
        return Movie(
            name = movieDTO.name,
            year = movieDTO.year
        )
    }

    fun fromMovie(movie: Movie): MovieDTO{
        return MovieDTO(
            name = movie.name,
            year = movie.year
        )
    }
}