package com.ranggacikal.moviedbapps.feature.movie.home

import com.ranggacikal.moviedbapps.core.common.UiState
import com.ranggacikal.moviedbapps.core.domain.model.Movie


data class HomeUiState(
    val popularMovies:
    UiState<List<Movie>> = UiState(),

    val nowPlayingMovies:
    UiState<List<Movie>> = UiState(),

    val topRatedMovies:
    UiState<List<Movie>> = UiState()
)