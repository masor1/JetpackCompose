package com.masorone.jetpackcompose.vknewsclient.ui.navigation

sealed class Screen(
    val route: String
) {
    object Home : Screen("home") {
        object NewsFeed : Screen("news_feed")
        object Comments : Screen("comments")
    }

    object Favourite : Screen("favourite")
    object Profile : Screen("profile")
}