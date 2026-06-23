package com.ranggacikal.moviedbapps.core.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class MovieResponseDto(
    val page: Int,
    val results: List<MovieDto>
)
