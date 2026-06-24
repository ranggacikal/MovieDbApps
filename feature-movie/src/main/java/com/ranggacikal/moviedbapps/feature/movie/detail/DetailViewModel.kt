package com.ranggacikal.moviedbapps.feature.movie.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ranggacikal.moviedbapps.core.common.UiState
import com.ranggacikal.moviedbapps.core.domain.model.Movie
import com.ranggacikal.moviedbapps.core.domain.usecase.GetReviewsUseCase
import com.ranggacikal.moviedbapps.core.domain.usecase.SaveFavoriteMovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getReviewsUseCase: GetReviewsUseCase,
    private val saveFavoriteMovieUseCase: SaveFavoriteMovieUseCase
) : ViewModel() {

    private val movie = savedStateHandle.get<Movie>("movieDetail")

    private val _uiState = MutableStateFlow(DetailUiState())
    val uiState = _uiState.asStateFlow()

    init {
        movie?.id?.let {
            getMovieReviews(it)
        }
    }

    private fun getMovieReviews(
        movieId: Int
    ) {
        viewModelScope.launch {
            _uiState.update {
                it.copy(
                    reviews = UiState(isLoading = true)
                )
            }

            runCatching {
                getReviewsUseCase(movieId)

            }.onSuccess { reviews ->
                _uiState.update {
                    it.copy(reviews = UiState(data = reviews))
                }

            }.onFailure { throwable ->
                _uiState.update {
                    it.copy(reviews = UiState(errorMessage = throwable.message))
                }
            }
        }
    }

    fun addMovie(movie: Movie) {
        viewModelScope.launch {
            saveFavoriteMovieUseCase(movie)
        }
    }

}