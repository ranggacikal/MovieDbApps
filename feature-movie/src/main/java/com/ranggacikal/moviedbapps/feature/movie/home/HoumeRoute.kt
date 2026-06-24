package com.ranggacikal.moviedbapps.feature.movie.home

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ranggacikal.moviedbapps.core.domain.model.Movie

@Composable
fun HomeRoute(
    onMovieClick: (Movie) -> Unit,
    viewModel: HomeViewModel =
        hiltViewModel()
) {
    val uiState =
        viewModel.uiState
            .collectAsStateWithLifecycle()
    HomeScreen(
        uiState = uiState.value,
        onMovieClick = onMovieClick,
        onRefresh = viewModel::refresh,
        onRetryPopular = viewModel::loadPopularMovie,
        onRetryNowPlaying = viewModel::loadNowPlayingMovies,
        onRetryTopRated = viewModel::loadTopRatedMovies
    )
}