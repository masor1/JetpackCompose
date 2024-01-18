package com.masorone.jetpackcompose.vknewsclient.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun VkNavGraph(
    navController: NavHostController,
    newsFeedContent: @Composable () -> Unit,
    favouriteContent: @Composable () -> Unit,
    profileContent: @Composable () -> Unit,
) {
    NavHost(
        navController = navController,
        startDestination = Screen.NewsFeed.route,
    ) {
        composable(Screen.NewsFeed.route) {
            newsFeedContent()
        }
        composable(Screen.Favourite.route) {
            favouriteContent()
        }
        composable(Screen.Profile.route) {
            profileContent()
        }
    }
}