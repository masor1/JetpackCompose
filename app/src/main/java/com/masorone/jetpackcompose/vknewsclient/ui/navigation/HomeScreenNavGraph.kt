package com.masorone.jetpackcompose.vknewsclient.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation

fun NavGraphBuilder.homeScreenNavGraph(
    newsFeedContent: @Composable () -> Unit,
    commentsContent: @Composable () -> Unit,
) {
    navigation(
        startDestination = Screen.Home.NewsFeed.route,
        route = Screen.Home.route
    ) {
        composable(Screen.Home.NewsFeed.route) {
            newsFeedContent()
        }
        composable(Screen.Home.Comments.route) {
            commentsContent()
        }
    }
}