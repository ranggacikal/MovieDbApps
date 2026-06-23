package com.ranggacikal.moviedbapps.core.domain.usecase

import com.ranggacikal.moviedbapps.core.domain.model.Movie
import com.ranggacikal.moviedbapps.core.domain.repository.MovieRepository
import javax.inject.Inject

class SaveFavoriteMovieUseCase @Inject constructor(
    private val repository: MovieRepository
) {

    suspend operator fun invoke(movie: Movie) {
        repository.saveFavorite(movie)
    }

}