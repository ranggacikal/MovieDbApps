package com.ranggacikal.moviedbapps.core.data.repository

import com.ranggacikal.moviedbapps.core.data.local.datasource.MovieLocalDataSource
import com.ranggacikal.moviedbapps.core.data.mapper.toDomain
import com.ranggacikal.moviedbapps.core.data.mapper.toEntity
import com.ranggacikal.moviedbapps.core.data.remote.datasource.MovieRemoteDataSource
import com.ranggacikal.moviedbapps.core.domain.model.Movie
import com.ranggacikal.moviedbapps.core.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val remote: MovieRemoteDataSource,
    private val local: MovieLocalDataSource
) : MovieRepository {

    override suspend fun getPopularMovies(): List<Movie> {
        return remote.getPopularMovies().map { it.toDomain() }
    }

    override suspend fun getNowPlayingMovies(): List<Movie> {
        return remote.getNowPlayingMovies().map { it.toDomain() }
    }

    override suspend fun getTopRatedMovies(): List<Movie> {
        return remote.getTopRatedMovies().map { it.toDomain() }
    }

    override fun getFavoriteMovies(): Flow<List<Movie>> {
        return local.getFavoriteMovies().map { list ->
            list.map { it.toDomain() }
        }
    }

    override suspend fun saveFavorite(movie: Movie) {
        local.insertMovie(movie.toEntity())
    }

    override suspend fun deleteFavorite(movieId: Int) {
        local.deleteMovie(movieId)
    }

    override suspend fun isFavoriteMovie(
        movieId: Int
    ): Boolean {
        return local.isFavoriteMovie(movieId)
    }
}