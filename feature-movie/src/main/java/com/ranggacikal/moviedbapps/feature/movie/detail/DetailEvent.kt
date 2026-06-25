package com.ranggacikal.moviedbapps.feature.movie.detail

sealed interface DetailEvent {
    data object FavoriteSaved : DetailEvent
    data object FavoriteDeleted: DetailEvent
    data class Error(
        val message: String
    ) : DetailEvent
}