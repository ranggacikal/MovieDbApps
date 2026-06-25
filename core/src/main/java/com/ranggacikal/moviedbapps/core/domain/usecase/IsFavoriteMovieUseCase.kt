package com.ranggacikal.moviedbapps.core.domain.usecase

import com.ranggacikal.moviedbapps.core.domain.repository.MovieRepository
import javax.inject.Inject

class IsFavoriteMovieUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    suspend operator fun invoke(movieId: Int): Boolean {
        return repository.isFavoriteMovie(movieId)
    }
}