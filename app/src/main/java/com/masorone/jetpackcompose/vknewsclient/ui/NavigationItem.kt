package com.masorone.jetpackcompose.vknewsclient.ui

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDestination.Companion.hierarchy
import com.masorone.jetpackcompose.R
import com.masorone.jetpackcompose.vknewsclient.ui.navigation.Screen

sealed class NavigationItem(
    private val screen: Screen,
    private val titleResId: Int,
    private val imageVector: ImageVector
) {

    context(RowScope)
    @Composable
    fun Show(navBackStackEntry: NavBackStackEntry?, onClick: (String) -> Unit) {
        val selected = navBackStackEntry?.destination?.hierarchy?.any {
            it.route == screen.route
        } ?: false
        NavigationBarItem(
            selected = selected,
            onClick = { if (!selected) onClick(screen.route) },
            label = { Text(stringResource(titleResId)) },
            icon = { Icon(imageVector = imageVector, contentDescription = null) },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = MaterialTheme.colorScheme.onPrimary,
                selectedTextColor = MaterialTheme.colorScheme.onPrimary,
                unselectedIconColor = MaterialTheme.colorScheme.onSecondary,
                unselectedTextColor = MaterialTheme.colorScheme.onSecondary,
            )
        )
    }

    object Home :
        NavigationItem(Screen.Home, R.string.vk_news_client_main_screen_home_title, Icons.Filled.Home)

    object Favourite :
        NavigationItem(Screen.Favourite, R.string.vk_news_client_main_screen_favourite_title, Icons.Filled.Favorite)

    object Profile :
        NavigationItem(Screen.Profile, R.string.vk_news_client_main_screen_profile_title, Icons.Filled.Person)
}