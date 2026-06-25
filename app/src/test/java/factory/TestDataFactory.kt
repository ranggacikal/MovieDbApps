package com.ranggacikal.moviedbapps.factory

import com.ranggacikal.moviedbapps.core.domain.model.Movie
import com.ranggacikal.moviedbapps.core.domain.model.Reviews


object TestDataFactory {

    fun movie() = Movie(
        id = 1,
        title = "Batman",
        overview = "Overview Batman",
        posterPath = "/poster.jpg"
    )

    fun movieList() =
        listOf(
            movie()
        )

    fun review() = Reviews(
        id = "1",
        author = "John",
        content = "Good Movie"
    )

    fun reviewList() =
        listOf(
            review()
        )
}