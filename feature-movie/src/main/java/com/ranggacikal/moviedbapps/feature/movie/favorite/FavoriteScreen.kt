package com.ranggacikal.moviedbapps.feature.movie.favorite

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ranggacikal.moviedbapps.core.domain.model.Movie
import com.ranggacikal.moviedbapps.feature.movie.component.TopBarView

@Composable
fun FavoriteScreen(
    uiState: FavoriteUiState,
    onBackClickk: () -> Unit,
    onMovieClick: (Movie) -> Unit
) {
    Scaffold(
        topBar = {
            TopBarView (
                title = "Favorite Movies",
                isShowRightIcon = false,
                isShowBackButton = true,
                onClickBackButton = {
                    onBackClickk()
                }
            )
        }
    ) { paddingValues ->

        FavoriteContent(
            modifier = Modifier.padding(paddingValues),
            uiState = uiState,
            onMovieClick = onMovieClick
        )
    }
}