package com.ranggacikal.moviedbapps.feature.movie.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.ranggacikal.moviedbapps.core.domain.model.Movie
import com.ranggacikal.moviedbapps.core.network.NetworkConstants
import com.ranggacikal.moviedbapps.feature.movie.component.EmptyView
import com.ranggacikal.moviedbapps.feature.movie.component.ErrorView
import com.ranggacikal.moviedbapps.feature.movie.component.LoadingDialog
import com.ranggacikal.moviedbapps.feature.movie.component.ReviewList
import com.ranggacikal.moviedbapps.feature.movie.component.SectionHeader

@Composable
fun DetailContent(
    movie: Movie?,
    uiState: DetailUiState,
    padding: PaddingValues
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
            .padding(padding)
    ) {
        item {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp)
                    .padding(horizontal = 14.dp),
                shape = RoundedCornerShape(16.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.surfaceVariant)
                ) {
                    AsyncImage(
                        model = NetworkConstants.IMAGE_URL + movie?.posterPath,
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }
            }
            Text(
                text = movie?.title.orEmpty(),
                style =
                    MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(
                    16.dp
                )
            )
            Text(
                text = movie?.overview.orEmpty(),
                modifier = Modifier.padding(
                    16.dp
                )
            )
        }
        item {
            SectionHeader(
                title = "Reviews"
            )
        }
        item {
            when {
                uiState.reviews.isLoading -> {
                    LoadingDialog(
                        message = "Load reviews"
                    )
                }

                uiState.reviews.errorMessage != null -> {
                    uiState.reviews.errorMessage.orEmpty().let {
                        ErrorView(
                            message =
                                it
                        )
                    }
                }

                uiState.reviews.data.isNullOrEmpty() -> {
                    EmptyView(
                        text = "No reviews available"
                    )
                }

                else -> {
                    ReviewList(
                        reviews =
                            uiState.reviews.data.orEmpty()
                    )
                }
            }
        }
    }
}