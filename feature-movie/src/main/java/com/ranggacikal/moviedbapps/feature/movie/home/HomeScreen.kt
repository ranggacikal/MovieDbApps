package com.ranggacikal.moviedbapps.feature.movie.home

import androidx.compose.runtime.Composable
import com.ranggacikal.moviedbapps.core.domain.model.Movie

@Composable
fun HomeScreen(
    uiState: HomeUiState,
    onMovieClick: (Movie) -> Unit,
    onRefresh: () -> Unit,
    onRetryPopular: () -> Unit,
    onRetryNowPlaying: () -> Unit,
    onRetryTopRated: () -> Unit
) {
    HomeContent(
        uiState = uiState,
        onMovieClick = onMovieClick,
        onRefresh = onRefresh,
        onRetryPopular = onRetryPopular,
        onRetryNowPlaying = onRetryNowPlaying,
        onRetryTopRated = onRetryTopRated
    )
}