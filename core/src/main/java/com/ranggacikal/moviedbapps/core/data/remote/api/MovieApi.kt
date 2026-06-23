package com.ranggacikal.moviedbapps.core.data.remote.api

import com.ranggacikal.moviedbapps.core.data.remote.dto.MovieResponseDto
import com.ranggacikal.moviedbapps.core.network.NetworkConstants.URL_GET_NOW_PLAYING_MOVIE
import com.ranggacikal.moviedbapps.core.network.NetworkConstants.URL_GET_POPULAR_MOVIE
import com.ranggacikal.moviedbapps.core.network.NetworkConstants.URL_GET_TOP_RATED_MOVIE
import retrofit2.http.GET

interface MovieApi {

    @GET(URL_GET_POPULAR_MOVIE)
    suspend fun getPopularMovies(): MovieResponseDto

    @GET(URL_GET_TOP_RATED_MOVIE)
    suspend fun getTopRatedMovies(): MovieResponseDto

    @GET(URL_GET_NOW_PLAYING_MOVIE)
    suspend fun getNowPlayingMovies(): MovieResponseDto

}