package com.ranggacikal.moviedbapps.core.data.remote.dto

data class ReviewsResponseDto(
    val id: Int,
    val page: Int,
    val results: List<ReviewsDto>
)
