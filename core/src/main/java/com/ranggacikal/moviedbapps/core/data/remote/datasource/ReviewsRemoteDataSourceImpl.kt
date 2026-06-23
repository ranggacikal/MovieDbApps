package com.ranggacikal.moviedbapps.core.data.remote.datasource

import com.ranggacikal.moviedbapps.core.data.remote.api.ReviewsApi
import com.ranggacikal.moviedbapps.core.data.remote.dto.ReviewsDto
import javax.inject.Inject

class ReviewsRemoteDataSourceImpl @Inject constructor(
    private val api: ReviewsApi
) : ReviewsRemoteDataSource {
    override suspend fun getMoviesReviews(movieId: Int): List<ReviewsDto> {
        return api.getMovieReviews(movieId).results
    }

}