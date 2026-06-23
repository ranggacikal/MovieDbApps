package com.ranggacikal.moviedbapps.core.data.repository

import com.ranggacikal.moviedbapps.core.data.mapper.toDomain
import com.ranggacikal.moviedbapps.core.data.remote.datasource.ReviewsRemoteDataSource
import com.ranggacikal.moviedbapps.core.domain.model.Reviews
import com.ranggacikal.moviedbapps.core.domain.repository.ReviewRepository
import javax.inject.Inject

class ReviewsRepositoryImpl @Inject constructor(
    private val remote: ReviewsRemoteDataSource
) : ReviewRepository {

    override suspend fun getReviewsMovie(movieId: Int): List<Reviews> {
        return remote.getMoviesReviews(movieId).map { it.toDomain() }
    }

}