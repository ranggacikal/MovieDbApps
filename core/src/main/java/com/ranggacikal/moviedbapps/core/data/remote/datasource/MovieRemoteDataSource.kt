package com.ranggacikal.moviedbapps.core.data.remote.datasource

import com.ranggacikal.moviedbapps.core.data.remote.dto.MovieDto

interface MovieRemoteDataSource {
    suspend fun getPopularMovies(): List<MovieDto>
    suspend fun getTopRatedMovies(): List<MovieDto>
    suspend fun getNowPlayingMovies(): List<MovieDto>
}