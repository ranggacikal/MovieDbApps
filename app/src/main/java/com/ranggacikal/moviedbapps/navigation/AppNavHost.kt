package com.ranggacikal.moviedbapps.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ranggacikal.moviedbapps.core.domain.model.Movie
import com.ranggacikal.moviedbapps.feature.movie.detail.DetailRoute
import com.ranggacikal.moviedbapps.feature.movie.detail.DetailScreen
import com.ranggacikal.moviedbapps.feature.movie.favorite.FavoriteRoute
import com.ranggacikal.moviedbapps.feature.movie.favorite.FavoriteScreen
import com.ranggacikal.moviedbapps.feature.movie.home.HomeRoute
import com.ranggacikal.moviedbapps.feature.movie.home.HomeScreen
import com.ranggacikal.moviedbapps.navigation.NavigationExt.KEY_MOVIE

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier
) {
    val navController =
        rememberNavController()
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = AppDestination.HOME
    ) {
        composable(
            route = AppDestination.HOME
        ) {
            HomeRoute(
                onMovieClick = { movie ->
                    navController.currentBackStackEntry
                        ?.savedStateHandle
                        ?.set(KEY_MOVIE, movie)

                    navController.navigate(
                        AppDestination.DETAIL
                    )
                },
                onFavoriteClick = {
                    navController.navigate(
                        AppDestination.FAVORITE
                    )
                }
            )
        }

        composable(
            route = AppDestination.DETAIL
        ) {
            val movie =
                navController.previousBackStackEntry
                    ?.savedStateHandle
                    ?.get<Movie>(KEY_MOVIE)
            DetailRoute(
                movie = movie,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }

        composable(
            route = AppDestination.FAVORITE
        ) {
            FavoriteRoute(
                onMovieClick = { movie ->
                    navController.currentBackStackEntry
                        ?.savedStateHandle
                        ?.set(KEY_MOVIE, movie)

                    navController.navigate(
                        AppDestination.DETAIL
                    )
                },
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}