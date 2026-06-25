package com.ranggacikal.moviedbapps.feature.favorite

import com.ranggacikal.moviedbapps.MainDispatcherRule
import com.ranggacikal.moviedbapps.core.domain.usecase.DeleteFavoriteMovieUseCase
import com.ranggacikal.moviedbapps.core.domain.usecase.GetFavoriteMoviesUseCase
import com.ranggacikal.moviedbapps.factory.TestDataFactory
import com.ranggacikal.moviedbapps.feature.movie.favorite.FavoriteViewModel
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class FavoriteViewModelTest {

    @get:Rule
    val dispatcherRule =
        MainDispatcherRule()

    private val getFavoriteMoviesUseCase =
        mockk<GetFavoriteMoviesUseCase>()

    @Test
    fun `favorite list loaded`() =
        runTest {

            val movies =
                TestDataFactory.movieList()

            every {
                getFavoriteMoviesUseCase()
            } returns flowOf(movies)

            val viewModel =
                FavoriteViewModel(
                    getFavoriteMoviesUseCase
                )

            advanceUntilIdle()

            assertEquals(
                movies,
                viewModel.uiState.value
                    .favoriteMovies.data
            )
        }
}