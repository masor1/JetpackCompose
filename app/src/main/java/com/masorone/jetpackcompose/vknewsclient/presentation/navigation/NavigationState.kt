package com.masorone.jetpackcompose.vknewsclient.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.rememberNavController
import com.masorone.jetpackcompose.vknewsclient.domain.FeedPost

class NavigationState(
    val navHostController: NavHostController
) {
    fun navigate(route: String) {
        navHostController.navigate(
            route = route,
            navOptions = NavOptions.Builder()
                .setLaunchSingleTop(true)
                .setPopUpTo(navHostController.graph.findStartDestination().id, inclusive = false, saveState = true)
                .setRestoreState(true)
                .build()
        )
    }

    fun navigateToComments(feedPost: FeedPost) {
        navHostController.navigate(Screen.Home.Comments.routeWithArgs(feedPost))
    }
}

@Composable
fun rememberNavigationState(
    navHostController: NavHostController = rememberNavController()
): NavigationState = remember {
    NavigationState(
        navHostController
    )
}