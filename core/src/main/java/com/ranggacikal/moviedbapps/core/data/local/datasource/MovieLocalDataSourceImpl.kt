package com.ranggacikal.moviedbapps.core.data.local.datasource

import com.ranggacikal.moviedbapps.core.data.local.dao.MovieDao
import com.ranggacikal.moviedbapps.core.data.local.entity.MovieEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieLocalDataSourceImpl @Inject constructor(
    private val dao: MovieDao
) : MovieLocalDataSource {

    override fun getFavoriteMovies(): Flow<List<MovieEntity>> {
        return dao.getFavoriteMovies()
    }

    override suspend fun insertMovie(movie: MovieEntity) {
        dao.insertMovie(movie)
    }

    override suspend fun deleteMovie(movieId: Int) {
        dao.deleteMovie(movieId)
    }

    override suspend fun isFavoriteMovie(movieId: Int): Boolean {
        return dao.isFavorite(movieId)
    }
}