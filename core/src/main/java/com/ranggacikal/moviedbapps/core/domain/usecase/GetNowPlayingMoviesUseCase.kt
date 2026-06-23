package com.ranggacikal.moviedbapps.core.domain.usecase

import com.ranggacikal.moviedbapps.core.domain.repository.MovieRepository
import javax.inject.Inject

class GetNowPlayingMoviesUseCase @Inject constructor(
    private val repository: MovieRepository
) {

    suspend operator fun invoke() = repository.getNowPlayingMovies()

}