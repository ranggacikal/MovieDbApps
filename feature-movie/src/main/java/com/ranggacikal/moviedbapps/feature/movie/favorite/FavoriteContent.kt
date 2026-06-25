package com.ranggacikal.moviedbapps.feature.movie.favorite

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ranggacikal.moviedbapps.core.domain.model.Movie
import com.ranggacikal.moviedbapps.feature.movie.component.EmptyView
import com.ranggacikal.moviedbapps.feature.movie.component.ErrorView
import com.ranggacikal.moviedbapps.feature.movie.component.FavoriteMovieItem
import com.ranggacikal.moviedbapps.feature.movie.component.LoadingDialog

@Composable
fun FavoriteContent(
    modifier: Modifier = Modifier,
    uiState: FavoriteUiState,
    onMovieClick: (Movie) -> Unit
) {
    when {
        uiState.favoriteMovies.isLoading -> {
            LoadingDialog(message = "Load Favorite Movie")
        }

        uiState.favoriteMovies.errorMessage != null -> {
            ErrorView(
                message = uiState.favoriteMovies.errorMessage.orEmpty()
            )
        }

        uiState.favoriteMovies.data.isNullOrEmpty() -> {
            EmptyView(
                text = "No favorite movies"
            )
        }

        else -> {
            LazyColumn(
                modifier = modifier.fillMaxSize()
            ) {
                items(
                    items = uiState.favoriteMovies.data.orEmpty(),
                    key = { it.id }
                ) { movie ->
                    FavoriteMovieItem(
                        movie = movie,
                        onMovieClick = onMovieClick
                    )
                }
            }
        }
    }
}