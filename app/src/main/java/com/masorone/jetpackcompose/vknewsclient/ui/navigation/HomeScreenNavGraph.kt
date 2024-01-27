package com.masorone.jetpackcompose.vknewsclient.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.masorone.jetpackcompose.vknewsclient.domain.FeedPost
import com.masorone.jetpackcompose.vknewsclient.ui.navigation.Screen.Companion.ROUTE_ARG_KEY_CONTENT_TEXT_ID
import com.masorone.jetpackcompose.vknewsclient.ui.navigation.Screen.Companion.ROUTE_ARG_KEY_FEED_POST_ID

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
                navArgument(ROUTE_ARG_KEY_FEED_POST_ID) { type = NavType.IntType },
                navArgument(ROUTE_ARG_KEY_CONTENT_TEXT_ID) { type = NavType.StringType }
            )
        ) {
            val feedPostId = it.arguments?.getInt(ROUTE_ARG_KEY_FEED_POST_ID) ?: 0
            val contentText = it.arguments?.getString(ROUTE_ARG_KEY_CONTENT_TEXT_ID) ?: ""
            commentsContent(FeedPost(feedPostId, contentText = contentText))
        }
    }
}