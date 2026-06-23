package com.ranggacikal.moviedbapps.core.domain.repository

import com.ranggacikal.moviedbapps.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

    suspend fun getPopularMovies(): List<Movie>

    suspend fun getTopRatedMovies(): List<Movie>

    suspend fun getNowPlayingMovies(): List<Movie>

    fun getFavoriteMovies(): Flow<List<Movie>>

    suspend fun saveFavorite(
        movie: Movie
    )

    suspend fun deleteFavorite(
        movieId: Int
    )
}