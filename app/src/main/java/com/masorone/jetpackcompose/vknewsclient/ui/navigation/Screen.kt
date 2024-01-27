package com.masorone.jetpackcompose.vknewsclient.ui.navigation

import com.google.gson.Gson
import com.masorone.jetpackcompose.vknewsclient.domain.FeedPost

sealed class Screen(
    val route: String
) {
    companion object {
        private const val ROUTE_HOME = "home"
        private const val ROUTE_NEWS_FEED = "news_feed"
        private const val ROUTE_COMMENTS = "comments"
        private const val ROUTE_FAVOURITE = "favourite"
        private const val ROUTE_PROFILE = "profile"

        private const val ROUTE_ARG_KEY = "/{%s}"
        private const val ROUTE_ARG_VALUE = "/%s"

        const val ROUTE_ARG_KEY_FEED_POST = "feed_post"
    }

    object Home : Screen(ROUTE_HOME) {
        object NewsFeed : Screen(ROUTE_NEWS_FEED)
        object Comments : Screen(
            ROUTE_COMMENTS +
                    String.format(ROUTE_ARG_KEY, ROUTE_ARG_KEY_FEED_POST)
        ) {
            fun routeWithArgs(feedPost: FeedPost): String {
                val feedPostGson = Gson().toJson(feedPost).encode()
                return ROUTE_COMMENTS + String.format(ROUTE_ARG_VALUE, feedPostGson)
            }
        }
    }

    object Favourite : Screen(ROUTE_FAVOURITE)
    object Profile : Screen(ROUTE_PROFILE)
}