package com.ranggacikal.moviedbapps.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ranggacikal.moviedbapps.feature.movie.detail.DetailScreen
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

                }
            )
        }

        composable(
            route = AppDestination.DETAIL
        ) {
            DetailScreen(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }

        composable(
            route = AppDestination.FAVORITE
        ) {
            FavoriteScreen(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}