package com.ranggacikal.moviedbapps.feature.movie.favorite

import com.ranggacikal.moviedbapps.core.common.UiState
import com.ranggacikal.moviedbapps.core.domain.model.Movie

data class FavoriteUiState(
    val favoriteMovies: UiState<List<Movie>> = UiState()
)
