package com.ranggacikal.moviedbapps.core.domain.usecase

import com.ranggacikal.core.domain.repository.MovieRepository
import javax.inject.Inject

class GetTopRatedMoviesUseCase @Inject constructor(
    private val repository: MovieRepository
) {

    suspend operator fun invoke() = repository.getTopRatedMovies()

}