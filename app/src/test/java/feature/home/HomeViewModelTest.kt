package com.ranggacikal.moviedbapps.feature.home

import com.ranggacikal.moviedbapps.MainDispatcherRule
import com.ranggacikal.moviedbapps.core.domain.usecase.GetNowPlayingMoviesUseCase
import com.ranggacikal.moviedbapps.core.domain.usecase.GetPopularMoviesUseCase
import com.ranggacikal.moviedbapps.core.domain.usecase.GetTopRatedMoviesUseCase
import com.ranggacikal.moviedbapps.factory.TestDataFactory
import com.ranggacikal.moviedbapps.feature.movie.home.HomeViewModel
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class HomeViewModelTest {

    @get:Rule
    val dispatcherRule =
        MainDispatcherRule()

    private val getPopularMoviesUseCase =
        mockk<GetPopularMoviesUseCase>()

    private val getNowPlayingMoviesUseCase =
        mockk<GetNowPlayingMoviesUseCase>()

    private val getTopRatedMoviesUseCase =
        mockk<GetTopRatedMoviesUseCase>()

    @Test
    fun `load popular movie success`() =
        runTest {

            val movies =
                TestDataFactory.movieList()

            coEvery {
                getPopularMoviesUseCase()
            } returns movies

            coEvery {
                getNowPlayingMoviesUseCase()
            } returns emptyList()

            coEvery {
                getTopRatedMoviesUseCase()
            } returns emptyList()

            val viewModel =
                HomeViewModel(
                    getPopularMoviesUseCase,
                    getNowPlayingMoviesUseCase,
                    getTopRatedMoviesUseCase
                )

            advanceUntilIdle()

            assertEquals(
                movies,
                viewModel.uiState.value
                    .popularMovies.data
            )
        }

    @Test
    fun `load popular movie error`() =
        runTest {

            coEvery {
                getPopularMoviesUseCase()
            } throws RuntimeException(
                "API Error"
            )

            coEvery {
                getNowPlayingMoviesUseCase()
            } returns emptyList()

            coEvery {
                getTopRatedMoviesUseCase()
            } returns emptyList()

            val viewModel =
                HomeViewModel(
                    getPopularMoviesUseCase,
                    getNowPlayingMoviesUseCase,
                    getTopRatedMoviesUseCase
                )

            advanceUntilIdle()

            assertEquals(
                "API Error",
                viewModel.uiState.value
                    .popularMovies.errorMessage
            )
        }
}