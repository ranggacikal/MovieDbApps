package com.ranggacikal.moviedbapps.core.data.remote.api

import com.ranggacikal.moviedbapps.core.data.remote.dto.ReviewsResponseDto
import com.ranggacikal.moviedbapps.core.network.NetworkConstants.URL_GET_MOVIE_REVIEWS
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ReviewsApi {

    @GET(URL_GET_MOVIE_REVIEWS)
    suspend fun getMovieReviews(
        @Path("movie_id") movieId: Int
    ): ReviewsResponseDto

}