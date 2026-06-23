package com.ranggacikal.moviedbapps.core.data.mapper

import com.ranggacikal.moviedbapps.core.data.local.entity.MovieEntity
import com.ranggacikal.moviedbapps.core.data.remote.dto.MovieDto
import com.ranggacikal.moviedbapps.core.domain.model.Movie

fun MovieDto.toDomain(): Movie {
    return Movie(
        id = id,
        title = title,
        overview = overview,
        posterPath = posterPath.orEmpty()
    )
}

fun MovieEntity.toDomain(): Movie {
    return Movie(
        id = id,
        title = title,
        overview = overview,
        posterPath = posterPath
    )
}

fun Movie.toEntity(): MovieEntity {
    return MovieEntity(
        id = id,
        title = title,
        overview = overview,
        posterPath = posterPath
    )
}