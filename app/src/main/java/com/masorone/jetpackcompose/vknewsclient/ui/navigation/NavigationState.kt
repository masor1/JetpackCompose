package com.masorone.jetpackcompose.vknewsclient.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
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
                .setPopUpTo(Screen.Home.route, inclusive = false, saveState = true)
                .setRestoreState(true)
                .build()
        )
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