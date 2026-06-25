package com.ranggacikal.moviedbapps.feature.movie.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ranggacikal.moviedbapps.core.common.UiState
import com.ranggacikal.moviedbapps.core.domain.model.Movie
import com.ranggacikal.moviedbapps.core.domain.usecase.DeleteFavoriteMovieUseCase
import com.ranggacikal.moviedbapps.core.domain.usecase.GetReviewsUseCase
import com.ranggacikal.moviedbapps.core.domain.usecase.IsFavoriteMovieUseCase
import com.ranggacikal.moviedbapps.core.domain.usecase.SaveFavoriteMovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getReviewsUseCase: GetReviewsUseCase,
    private val saveFavoriteMovieUseCase: SaveFavoriteMovieUseCase,
    private val isFavoriteMovieUseCase: IsFavoriteMovieUseCase,
    private val deleteFavoriteMovieUseCase: DeleteFavoriteMovieUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(DetailUiState())
    val uiState = _uiState.asStateFlow()

    private val _event =
        MutableSharedFlow<DetailEvent>()
    val event =
        _event.asSharedFlow()

    fun getMovieReviews(
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
            _uiState.update {
                it.copy(
                    isSavingFavorite = true
                )
            }
            runCatching {
                saveFavoriteMovieUseCase(movie)
            }.onSuccess {
                _uiState.update {
                    it.copy(
                        isFavoriteAlready = true
                    )
                }
                _event.emit(
                    DetailEvent.FavoriteSaved
                )
            }.onFailure { throwable ->
                _event.emit(
                    DetailEvent.Error(
                        throwable.message
                            ?: "Failed to save favorite"
                    )
                )
            }
            _uiState.update {
                it.copy(
                    isSavingFavorite = false
                )
            }
        }
    }

    fun deleteMovie(movie: Movie) {
        viewModelScope.launch {
            _uiState.update {
                it.copy(
                    isDeleteFavorite = true
                )
            }
            runCatching {
                deleteFavoriteMovieUseCase(movie.id)
            }.onSuccess {
                _uiState.update {
                    it.copy(
                        isFavoriteAlready = false
                    )
                }
                _event.emit(
                    DetailEvent.FavoriteDeleted
                )
            }.onFailure { throwable ->
                _event.emit(
                    DetailEvent.Error(
                        throwable.message
                            ?: "Failed to save favorite"
                    )
                )
            }
            _uiState.update {
                it.copy(
                    isDeleteFavorite = false
                )
            }
        }
    }

    fun checkFavorite(movieId: Int) {
        viewModelScope.launch {
            val isFavorite = isFavoriteMovieUseCase(movieId)
            _uiState.update {
                it.copy(isFavoriteAlready = isFavorite)
            }
        }
    }

}