package com.ranggacikal.moviedbapps.core.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class ReviewsResponseDto(
    val id: Int,
    val page: Int,
    val results: List<ReviewsDto>
)
