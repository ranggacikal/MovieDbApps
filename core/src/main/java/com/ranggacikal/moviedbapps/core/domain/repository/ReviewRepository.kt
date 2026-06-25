package com.ranggacikal.moviedbapps.core.domain.repository

import com.ranggacikal.moviedbapps.core.domain.model.Movie
import com.ranggacikal.moviedbapps.core.domain.model.Reviews

interface ReviewRepository {

    suspend fun getReviewsMovie(
        movieId: Int
    ): List<Reviews>

}