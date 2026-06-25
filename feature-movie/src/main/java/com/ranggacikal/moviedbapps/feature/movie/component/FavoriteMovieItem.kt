package com.ranggacikal.moviedbapps.feature.movie.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.ranggacikal.moviedbapps.core.domain.model.Movie
import com.ranggacikal.moviedbapps.core.network.NetworkConstants

@Composable
fun FavoriteMovieItem(
    movie: Movie,
    onMovieClick: (Movie) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 16.dp,
                vertical = 8.dp
            ),
        onClick = {
            onMovieClick(movie)
        }
    ) {
        Row(
            modifier = Modifier.padding(12.dp)
        ) {
            AsyncImage(
                model = NetworkConstants.IMAGE_URL + movie.posterPath,
                contentDescription = movie.title,
                modifier = Modifier
                    .width(80.dp)
                    .height(120.dp)
            )
            Spacer(
                modifier = Modifier.width(12.dp)
            )
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = movie.title,
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(
                    modifier = Modifier.height(8.dp)
                )
                Text(
                    text = movie.overview,
                    style = MaterialTheme.typography.labelMedium
                )
            }
        }
    }
}