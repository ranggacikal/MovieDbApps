package com.ranggacikal.moviedbapps.feature.movie.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.ranggacikal.moviedbapps.core.domain.model.Movie
import com.ranggacikal.moviedbapps.core.network.NetworkConstants

@Composable
fun MovieCard(
    movie: Movie,
    onMovieClick: (Movie) -> Unit
) {
    Card(
        modifier = Modifier
            .width(150.dp)
            .clickable {
                onMovieClick(movie)
            },
        shape = RoundedCornerShape(12.dp)
    ) {
        Column {
            AsyncImage(
                model = NetworkConstants.IMAGE_URL + movie.posterPath,
                contentDescription = movie.title,
                modifier = Modifier
                    .height(220.dp)
                    .fillMaxWidth()
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Text(
                text = movie.title,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(
                    horizontal = 8.dp
                )
            )

            Spacer(
                modifier = Modifier.height(4.dp)
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )
        }
    }
}