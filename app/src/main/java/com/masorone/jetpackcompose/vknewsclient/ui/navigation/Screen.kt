package com.masorone.jetpackcompose.vknewsclient.ui.navigation

sealed class Screen(
    val route: String
) {
    object NewsFeed : Screen("news_feed")
    object Favourite : Screen("favourite")
    object Profile : Screen("profile")
}