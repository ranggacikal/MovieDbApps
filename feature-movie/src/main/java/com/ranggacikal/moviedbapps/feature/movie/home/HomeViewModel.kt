package com.ranggacikal.moviedbapps.feature.movie.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ranggacikal.moviedbapps.core.common.UiState
import com.ranggacikal.moviedbapps.core.domain.usecase.GetNowPlayingMoviesUseCase
import com.ranggacikal.moviedbapps.core.domain.usecase.GetPopularMoviesUseCase
import com.ranggacikal.moviedbapps.core.domain.usecase.GetTopRatedMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase,
    private val getNowPlayingMoviesUseCase: GetNowPlayingMoviesUseCase,
    private val getTopRatedMoviesUseCase: GetTopRatedMoviesUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState = _uiState.asStateFlow()

    init {
        loadPopularMovie()
        loadTopRatedMovies()
        loadNowPlayingMovies()
    }

    fun refresh() {
        loadPopularMovie()
        loadTopRatedMovies()
        loadNowPlayingMovies()
    }

    fun loadPopularMovie() {
        viewModelScope.launch {
            _uiState.update {
                it.copy(
                    popularMovies = UiState(isLoading = true)
                )
            }
            runCatching {
                getPopularMoviesUseCase()

            }.onSuccess { movies ->
                _uiState.update {
                    it.copy(
                        popularMovies = UiState(data = movies)
                    )
                }

            }.onFailure { throwable ->

                _uiState.update {
                    it.copy(
                        popularMovies = UiState(errorMessage = throwable.message)
                    )
                }
            }
        }
    }

    fun loadNowPlayingMovies() {
        viewModelScope.launch {
            _uiState.update {
                it.copy(
                    nowPlayingMovies = UiState(isLoading = true)
                )
            }

            runCatching {
                getNowPlayingMoviesUseCase()
            }.onSuccess { movies ->
                _uiState.update {
                    it.copy(
                        nowPlayingMovies = UiState(data = movies)
                    )
                }
            }.onFailure { throwable ->
                _uiState.update {
                    it.copy(
                        nowPlayingMovies = UiState(errorMessage = throwable.message)
                    )
                }
            }
        }
    }

    fun loadTopRatedMovies() {
        viewModelScope.launch {
            _uiState.update {
                it.copy(
                    topRatedMovies = UiState(isLoading = true)
                )
            }

            runCatching {
                getTopRatedMoviesUseCase()
            }.onSuccess { movies ->
                _uiState.update {
                    it.copy(
                        topRatedMovies = UiState(data = movies)
                    )
                }

            }.onFailure { throwable ->
                _uiState.update {
                    it.copy(
                        topRatedMovies = UiState(errorMessage = throwable.message)
                    )
                }
            }
        }
    }

}