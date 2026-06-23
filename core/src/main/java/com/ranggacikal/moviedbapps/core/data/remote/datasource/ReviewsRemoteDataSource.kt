package com.ranggacikal.moviedbapps.core.data.remote.datasource

import com.ranggacikal.moviedbapps.core.data.remote.dto.ReviewsDto

interface ReviewsRemoteDataSource {
    suspend fun getMoviesReviews(movieId: Int): List<ReviewsDto>
}