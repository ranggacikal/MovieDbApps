package com.ranggacikal.moviedbapps.feature.movie.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.ranggacikal.moviedbapps.core.domain.model.Reviews

@Composable
fun ReviewList(
    reviews: List<Reviews>
) {
    Column {
        reviews.forEach { review ->
            ReviewItem(
                review = review
            )
        }
    }
}