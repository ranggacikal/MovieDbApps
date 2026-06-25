package com.ranggacikal.moviedbapps.core.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class ReviewsDto(
    val id: String,
    val author: String,
    val content: String
)
