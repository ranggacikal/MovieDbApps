package com.ranggacikal.moviedbapps.feature.movie.favorite

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ranggacikal.moviedbapps.core.domain.model.Movie

@Composable
fun FavoriteRoute(
    onMovieClick: (Movie) -> Unit,
    onBackClick: () -> Unit,
    viewModel: FavoriteViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    FavoriteScreen(
        uiState = uiState,
        onMovieClick = onMovieClick,
        onBackClickk = {
            onBackClick()
        }
    )
}