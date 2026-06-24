package com.ranggacikal.moviedbapps.core.domain.usecase

import com.ranggacikal.moviedbapps.core.common.Constants.MOVIE_LIMIT
import com.ranggacikal.moviedbapps.core.domain.repository.MovieRepository
import javax.inject.Inject

class GetTopRatedMoviesUseCase @Inject constructor(
    private val repository: MovieRepository
) {

    suspend operator fun invoke() = repository.getTopRatedMovies().take(MOVIE_LIMIT)

}