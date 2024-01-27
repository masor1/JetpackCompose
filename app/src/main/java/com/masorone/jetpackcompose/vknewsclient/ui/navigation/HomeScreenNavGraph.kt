package com.masorone.jetpackcompose.vknewsclient.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.google.gson.Gson
import com.masorone.jetpackcompose.vknewsclient.domain.FeedPost
import com.masorone.jetpackcompose.vknewsclient.ui.navigation.Screen.Companion.ROUTE_ARG_KEY_FEED_POST

fun NavGraphBuilder.homeScreenNavGraph(
    newsFeedContent: @Composable () -> Unit,
    commentsContent: @Composable (FeedPost) -> Unit,
) {
    navigation(
        startDestination = Screen.Home.NewsFeed.route,
        route = Screen.Home.route
    ) {
        composable(Screen.Home.NewsFeed.route) {
            newsFeedContent()
        }
        composable(
            route = Screen.Home.Comments.route,
            arguments = listOf(
                navArgument(ROUTE_ARG_KEY_FEED_POST) { type = NavType.StringType }
            )
        ) {
            val feedPost = Gson().fromJson(it.arguments?.getString(ROUTE_ARG_KEY_FEED_POST), FeedPost::class.java)
            commentsContent(feedPost)
        }
    }
}