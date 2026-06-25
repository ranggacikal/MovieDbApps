package com.ranggacikal.moviedbapps.feature.movie.home

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmarks
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import com.ranggacikal.moviedbapps.core.domain.model.Movie
import com.ranggacikal.moviedbapps.feature.movie.component.TopBarView

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    uiState: HomeUiState,
    onMovieClick: (Movie) -> Unit,
    onRefresh: () -> Unit,
    onRetryPopular: () -> Unit,
    onRetryNowPlaying: () -> Unit,
    onRetryTopRated: () -> Unit,
    onFavoriteClicked: () -> Unit
) {
    Scaffold(
        topBar = {
            TopBarView(
                title = "Movie DB Apps",
                icon = Icons.Default.Bookmarks
            ) { onFavoriteClicked() }
        }
    ) { paddingValues ->
        HomeContent(
            uiState = uiState,
            onMovieClick = onMovieClick,
            onRefresh = onRefresh,
            onRetryPopular = onRetryPopular,
            onRetryNowPlaying = onRetryNowPlaying,
            onRetryTopRated = onRetryTopRated,
            padding = paddingValues
        )
    }
}