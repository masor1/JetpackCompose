package com.masorone.jetpackcompose.vknewsclient.presentation.main

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.currentBackStackEntryAsState
import com.masorone.jetpackcompose.ui.CustomPreview
import com.masorone.jetpackcompose.ui.theme.JetpackComposeTheme
import com.masorone.jetpackcompose.vknewsclient.presentation.navigation.VkNavGraph
import com.masorone.jetpackcompose.vknewsclient.presentation.navigation.rememberNavigationState
import com.masorone.jetpackcompose.vknewsclient.presentation.screen_home.comments.CommentsScreen
import com.masorone.jetpackcompose.vknewsclient.presentation.screen_home.posts.PostsScreen

@Composable
fun MainScreen() {
    val navigationState = rememberNavigationState()

    Scaffold(
        bottomBar = {
            NavigationBar {
                val navBackStackEntry by navigationState.navHostController.currentBackStackEntryAsState()
                val navigationItems = listOf(
                    NavigationItem.Home,
                    NavigationItem.Favourite,
                    NavigationItem.Profile
                )
                navigationItems.forEach { navItem ->
                    navItem.Show(navBackStackEntry = navBackStackEntry) { route ->
                        navigationState.navigate(route = route)
                    }
                }
            }
        }
    ) { paddingValues ->
        VkNavGraph(
            navController = navigationState.navHostController,
            newsFeedContent = {
                PostsScreen(paddingValues = paddingValues) { feedPost ->
                    navigationState.navigateToComments(feedPost)
                }
            },
            commentsContent = { feedPost ->
                CommentsScreen(
                    feedPost = feedPost,
                    paddingValues = paddingValues
                ) {
                    navigationState.navHostController.popBackStack()
                }
            },
            favouriteContent = {
                TextCounter("Favourite")
            },
            profileContent = {
                TextCounter("Profile")
            }
        )
    }
}

@Composable
private fun TextCounter(text: String) {
    var count by rememberSaveable {
        mutableIntStateOf(0)
    }
    Text(
        text = "$text Count: $count",
        fontSize = 42.sp,
        modifier = Modifier
            .fillMaxSize()
            .clickable {
                count++
            }
    )
}

@Composable
@CustomPreview
private fun VkNewsMainScreenLight() {
    JetpackComposeTheme(darkTheme = false) {
        MainScreen()
    }
}

@Composable
@CustomPreview
private fun VkNewsMainScreenDark() {
    JetpackComposeTheme(darkTheme = true) {
        MainScreen()
    }
}