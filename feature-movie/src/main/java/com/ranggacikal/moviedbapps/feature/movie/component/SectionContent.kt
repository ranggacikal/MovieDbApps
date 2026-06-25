package com.ranggacikal.moviedbapps.feature.movie.component

import androidx.compose.runtime.Composable
import com.ranggacikal.moviedbapps.core.common.UiState
import com.ranggacikal.moviedbapps.core.domain.model.Movie

@Composable
fun SectionContent(
    title: String,
    state: UiState<List<Movie>>,
    onMovieClick: (Movie) -> Unit,
    onRetry: () -> Unit
) {
    when {
        state.isLoading -> {
            LoadingDialog(
                message = "Load Movie"
            )
        }
        state.errorMessage != null -> {
            state.errorMessage.orEmpty().let {
                ErrorView(
                    message = it,
                    onRetry = onRetry
                )
            }
        }
        state.data.isNullOrEmpty() -> {
            EmptyView(
                text = "No movie found"
            )
        }
        else -> {
            state.data.orEmpty().let {
                MovieSection(
                    title = title,
                    movies = it,
                    onMovieClick = onMovieClick
                )
            }
        }
    }
}