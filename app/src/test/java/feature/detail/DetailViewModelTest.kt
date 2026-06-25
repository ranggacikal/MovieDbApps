package com.ranggacikal.moviedbapps.feature.detail

import androidx.lifecycle.SavedStateHandle
import com.ranggacikal.moviedbapps.MainDispatcherRule
import com.ranggacikal.moviedbapps.core.domain.usecase.DeleteFavoriteMovieUseCase
import com.ranggacikal.moviedbapps.core.domain.usecase.GetReviewsUseCase
import com.ranggacikal.moviedbapps.core.domain.usecase.IsFavoriteMovieUseCase
import com.ranggacikal.moviedbapps.core.domain.usecase.SaveFavoriteMovieUseCase
import com.ranggacikal.moviedbapps.factory.TestDataFactory
import com.ranggacikal.moviedbapps.feature.movie.detail.DetailViewModel
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class DetailViewModelTest {

    @get:Rule
    val dispatcherRule = MainDispatcherRule()

    private val getReviewsUseCase =
        mockk<GetReviewsUseCase>()

    private val saveFavoriteMovieUseCase =
        mockk<SaveFavoriteMovieUseCase>()

    private val isFavoriteMovieUseCase =
        mockk<IsFavoriteMovieUseCase>()

    private val deleteFavoriteMovieUseCase =
        mockk<DeleteFavoriteMovieUseCase>()

    private fun createViewModel() =
        DetailViewModel(
            savedStateHandle = SavedStateHandle(),
            getReviewsUseCase = getReviewsUseCase,
            saveFavoriteMovieUseCase = saveFavoriteMovieUseCase,
            isFavoriteMovieUseCase = isFavoriteMovieUseCase,
            deleteFavoriteMovieUseCase = deleteFavoriteMovieUseCase
        )

    @Test
    fun `getMovieReviews success`() = runTest {

        val reviews =
            TestDataFactory.reviewList()

        coEvery {
            getReviewsUseCase(1)
        } returns reviews

        val viewModel = createViewModel()

        viewModel.getMovieReviews(1)

        advanceUntilIdle()

        assertEquals(
            reviews,
            viewModel.uiState.value.reviews.data
        )
    }

    @Test
    fun `getMovieReviews error`() = runTest {

        coEvery {
            getReviewsUseCase(1)
        } throws RuntimeException("Review Error")

        val viewModel = createViewModel()

        viewModel.getMovieReviews(1)

        advanceUntilIdle()

        assertEquals(
            "Review Error",
            viewModel.uiState.value.reviews.errorMessage
        )
    }

    @Test
    fun `addMovie success should update favorite state`() =
        runTest {

            val movie =
                TestDataFactory.movie()

            coEvery {
                saveFavoriteMovieUseCase(movie)
            } returns Unit

            val viewModel = createViewModel()

            viewModel.addMovie(movie)

            advanceUntilIdle()

            assertTrue(
                viewModel.uiState.value.isFavoriteAlready
            )

            assertFalse(
                viewModel.uiState.value.isSavingFavorite
            )

            coVerify {
                saveFavoriteMovieUseCase(movie)
            }
        }

    @Test
    fun `deleteMovie success should update favorite state`() =
        runTest {

            val movie =
                TestDataFactory.movie()

            coEvery {
                deleteFavoriteMovieUseCase(movie.id)
            } returns Unit

            val viewModel = createViewModel()

            viewModel.deleteMovie(movie)

            advanceUntilIdle()

            assertFalse(
                viewModel.uiState.value.isFavoriteAlready
            )

            assertFalse(
                viewModel.uiState.value.isDeleteFavorite
            )

            coVerify {
                deleteFavoriteMovieUseCase(movie.id)
            }
        }

    @Test
    fun `checkFavorite true`() =
        runTest {

            coEvery {
                isFavoriteMovieUseCase(1)
            } returns true

            val viewModel = createViewModel()

            viewModel.checkFavorite(1)

            advanceUntilIdle()

            assertTrue(
                viewModel.uiState.value.isFavoriteAlready
            )
        }

    @Test
    fun `checkFavorite false`() =
        runTest {

            coEvery {
                isFavoriteMovieUseCase(1)
            } returns false

            val viewModel = createViewModel()

            viewModel.checkFavorite(1)

            advanceUntilIdle()

            assertFalse(
                viewModel.uiState.value.isFavoriteAlready
            )
        }
}