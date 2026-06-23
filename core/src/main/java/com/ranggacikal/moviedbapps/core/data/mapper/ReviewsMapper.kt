package com.ranggacikal.moviedbapps.core.data.mapper

import com.ranggacikal.moviedbapps.core.data.remote.dto.ReviewsDto
import com.ranggacikal.moviedbapps.core.domain.model.Reviews

fun ReviewsDto.toDomain(): Reviews {
    return Reviews(
        id = id,
        author = author,
        content = content
    )
}