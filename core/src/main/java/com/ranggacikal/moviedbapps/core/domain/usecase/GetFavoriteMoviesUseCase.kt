package com.ranggacikal.moviedbapps.core.domain.usecase

import com.ranggacikal.core.domain.repository.MovieRepository
import javax.inject.Inject

class GetFavoriteMoviesUseCase @Inject constructor(
    private val repository: MovieRepository
) {

    operator fun invoke() = repository.getFavoriteMovies()

}