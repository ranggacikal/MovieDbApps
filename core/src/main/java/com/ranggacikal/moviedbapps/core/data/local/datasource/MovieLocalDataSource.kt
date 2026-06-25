package com.ranggacikal.moviedbapps.core.data.local.datasource

import com.ranggacikal.moviedbapps.core.data.local.entity.MovieEntity
import kotlinx.coroutines.flow.Flow

interface MovieLocalDataSource {
    fun getFavoriteMovies(): Flow<List<MovieEntity>>
    suspend fun insertMovie(movie: MovieEntity)
    suspend fun deleteMovie(movieId: Int)
    suspend fun isFavoriteMovie(movieId: Int): Boolean

}