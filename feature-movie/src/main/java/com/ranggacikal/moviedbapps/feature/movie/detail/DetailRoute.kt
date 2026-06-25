package com.ranggacikal.moviedbapps.feature.movie.detail

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ranggacikal.moviedbapps.core.domain.model.Movie

@Composable
fun DetailRoute(
    movie: Movie?,
    onBackClick: () -> Unit,
    viewModel: DetailViewModel =
        hiltViewModel()
) {
    val snackbarHostState =
        remember {
            SnackbarHostState()
        }
    CallReview(movie, viewModel)
    ObserveSaveMovie(viewModel, snackbarHostState)
    val uiState = viewModel.uiState.collectAsStateWithLifecycle()
    DetailScreen(
        movie = movie,
        uiState = uiState.value,
        snackbarHostState = snackbarHostState,
        onClickFavorite = {
            movie?.let { viewModel.addMovie(it) }
        },
        onClickDelete = {
            movie?.let { viewModel.deleteMovie(it) }
        },
        onBackClick = onBackClick
    )
}

@Composable
private fun CallReview(
    movie: Movie?,
    viewModel: DetailViewModel
) {
    LaunchedEffect(movie?.id) {
        movie?.id?.let {
            viewModel.getMovieReviews(it)
            viewModel.checkFavorite(it)
        }
    }
}

@Composable
private fun ObserveSaveMovie(
    viewModel: DetailViewModel,
    snackbarHostState: SnackbarHostState
) {
    LaunchedEffect(Unit) {
        viewModel.event.collect { event ->
            when (event) {
                DetailEvent.FavoriteSaved -> {
                    snackbarHostState.showSnackbar("Movie added to favorites")
                }
                DetailEvent.FavoriteDeleted -> {
                    snackbarHostState.showSnackbar("Movie deleted from favorites")
                }
                is DetailEvent.Error -> {
                    snackbarHostState.showSnackbar(
                        event.message
                    )
                }
            }
        }
    }
}

