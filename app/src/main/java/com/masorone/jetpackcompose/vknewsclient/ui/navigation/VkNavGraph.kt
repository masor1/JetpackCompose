package com.masorone.jetpackcompose.vknewsclient.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.masorone.jetpackcompose.vknewsclient.domain.FeedPost

@Composable
fun VkNavGraph(
    navController: NavHostController,
    newsFeedContent: @Composable () -> Unit,
    commentsContent: @Composable (FeedPost) -> Unit,
    favouriteContent: @Composable () -> Unit,
    profileContent: @Composable () -> Unit,
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
    ) {
        homeScreenNavGraph(
            newsFeedContent = newsFeedContent,
            commentsContent = commentsContent
        )
        composable(Screen.Favourite.route) {
            favouriteContent()
        }
        composable(Screen.Profile.route) {
            profileContent()
        }
    }
}