package com.ranggacikal.moviedbapps.feature.movie.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ranggacikal.moviedbapps.core.domain.model.Reviews

@Composable
fun ReviewItem(
    review: Reviews
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 16.dp,
                vertical = 12.dp
            )
    ) {

        Text(
            text = review.author,
            style = MaterialTheme.typography.titleSmall
        )

        Text(
            text = review.content,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(
                top = 8.dp
            )
        )

        HorizontalDivider(
            modifier = Modifier.padding(
                top = 12.dp
            )
        )
    }
}