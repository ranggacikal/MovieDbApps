package com.ranggacikal.moviedbapps.feature.movie.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ranggacikal.moviedbapps.core.domain.model.Movie
import com.ranggacikal.moviedbapps.feature.movie.component.SectionContent

@Composable
fun HomeContent(
    uiState: HomeUiState,
    onMovieClick: (Movie) -> Unit,
    onRefresh: () -> Unit,
    onRetryPopular: () -> Unit,
    onRetryNowPlaying: () -> Unit,
    onRetryTopRated: () -> Unit,
    padding: PaddingValues
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
    ) {
        item {
            SectionContent(
                title = "Popular Movies",
                state = uiState.popularMovies,
                onMovieClick = onMovieClick,
                onRetry = onRetryPopular
            )
        }
        item {
            SectionContent(
                title = "Now Playing",
                state = uiState.nowPlayingMovies,
                onMovieClick = onMovieClick,
                onRetry = onRetryNowPlaying
            )
        }
        item {
            SectionContent(
                title = "Top Rated",
                state = uiState.topRatedMovies,
                onMovieClick = onMovieClick,
                onRetry = onRetryTopRated
            )
        }
    }
}