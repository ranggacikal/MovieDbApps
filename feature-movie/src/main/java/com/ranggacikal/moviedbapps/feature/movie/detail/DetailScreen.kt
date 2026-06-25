package com.ranggacikal.moviedbapps.feature.movie.detail

import android.content.Intent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Polyline
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.ranggacikal.moviedbapps.core.domain.model.Movie
import com.ranggacikal.moviedbapps.feature.movie.component.TopBarView

@Composable
fun DetailScreen(
    movie: Movie?,
    uiState: DetailUiState,
    onClickFavorite: () -> Unit = {},
    onClickDelete: () -> Unit = {},
    onBackClick: () -> Unit,
    snackbarHostState: SnackbarHostState
) {
    val context = LocalContext.current
    Scaffold(
        bottomBar = {
            if (uiState.isFavoriteAlready.not()) {
                Button(
                    modifier = Modifier.fillMaxWidth()
                        .padding(24.dp),
                    onClick = {
                        onClickFavorite()
                    }
                ) {
                    Text("Add To Favorite")
                }
            } else {
                Button(
                    modifier = Modifier.fillMaxWidth()
                        .padding(24.dp),
                    onClick = {
                        onClickDelete()
                    }
                ) {
                    Text("Delete From Favorite")
                }
            }
        },
        snackbarHost = {
            SnackbarHost(
                hostState = snackbarHostState
            )
        },
        topBar = {
            TopBarView(
                title = "Movie Detail",
                icon = Icons.Default.Polyline,
                isShowBackButton = true,
                onClickBackButton = {
                    onBackClick()
                }
            ) {
                val intent =
                    Intent(Intent.ACTION_SEND).apply {
                        type = "text/plain"
                        putExtra(
                            Intent.EXTRA_TEXT,
                            """
                            ${movie?.title}
                            ${movie?.overview}
                            """.trimIndent()
                        )
                    }
                context.startActivity(
                    Intent.createChooser(
                        intent,
                        "Share Movie"
                    )
                )
            }
        }
    ) { paddingValues ->
        DetailContent(
            movie = movie,
            uiState = uiState,
            padding = paddingValues
        )
    }
}