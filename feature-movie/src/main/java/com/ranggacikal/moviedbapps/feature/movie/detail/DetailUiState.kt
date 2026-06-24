package com.ranggacikal.moviedbapps.feature.movie.detail

import com.ranggacikal.moviedbapps.core.common.UiState
import com.ranggacikal.moviedbapps.core.domain.model.Movie
import com.ranggacikal.moviedbapps.core.domain.model.Reviews

data class DetailUiState(
    val movieDetail: Movie? = null,
    val reviews: UiState<List<Reviews>> = UiState()
)