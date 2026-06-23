package com.ranggacikal.moviedbapps.core.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class ReviewsDto(
    val id: Int,
    val author: String,
    val content: String
)
