package com.ranggacikal.moviedbapps.core.domain.usecase

import com.ranggacikal.moviedbapps.core.domain.repository.ReviewRepository
import javax.inject.Inject

class GetReviewsUseCase @Inject constructor(
    private val repository: ReviewRepository
) {

    suspend operator fun invoke(movieId: Int) = repository.getReviewsMovie(movieId)

}