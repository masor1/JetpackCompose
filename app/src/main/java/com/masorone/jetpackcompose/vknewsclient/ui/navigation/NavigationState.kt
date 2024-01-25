package com.masorone.jetpackcompose.vknewsclient.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.rememberNavController

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

    fun navigateToComments() {
        navHostController.navigate(Screen.Home.Comments.route)
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