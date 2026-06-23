package com.ranggacikal.moviedbapps.core.data.remote.datasource

import com.ranggacikal.moviedbapps.core.data.remote.api.MovieApi
import com.ranggacikal.moviedbapps.core.data.remote.dto.MovieDto
import javax.inject.Inject

class MovieRemoteDataSourceImpl @Inject constructor(
    private val api: MovieApi
) : MovieRemoteDataSource {

    override suspend fun getPopularMovies(): List<MovieDto> {
        return api.getPopularMovies().results
    }

    override suspend fun getTopRatedMovies(): List<MovieDto> {
        return api.getTopRatedMovies().results
    }

    override suspend fun getNowPlayingMovies(): List<MovieDto> {
        return api.getNowPlayingMovies().results
    }
}