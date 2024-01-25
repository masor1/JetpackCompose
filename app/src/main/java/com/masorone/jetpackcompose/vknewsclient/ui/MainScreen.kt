package com.masorone.jetpackcompose.vknewsclient.ui

import androidx.activity.compose.BackHandler
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
import com.masorone.jetpackcompose.vknewsclient.domain.FeedPost
import com.masorone.jetpackcompose.vknewsclient.ui.navigation.Screen
import com.masorone.jetpackcompose.vknewsclient.ui.navigation.VkNavGraph
import com.masorone.jetpackcompose.vknewsclient.ui.navigation.rememberNavigationState
import com.masorone.jetpackcompose.vknewsclient.ui.screen_home.comments.CommentsScreen
import com.masorone.jetpackcompose.vknewsclient.ui.screen_home.posts.PostsScreen

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
                PostsScreen(paddingValues = paddingValues) {
                    navigationState.navigate(Screen.Home.Comments.route)
                }
            },
            commentsContent = {
                CommentsScreen(
                    feedPost = FeedPost(1),
                    paddingValues = paddingValues
                ) {
                    navigationState.navigate(Screen.Home.NewsFeed.route)
                }
                BackHandler {
                    navigationState.navigate(Screen.Home.NewsFeed.route)
                }
            },
            favouriteContent = { TextCounter("Favourite") },
            profileContent = { TextCounter("Profile") }
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
fun VkNewsMainScreenLight() {
    JetpackComposeTheme(darkTheme = false) {
        MainScreen()
    }
}

@Composable
@CustomPreview
fun VkNewsMainScreenDark() {
    JetpackComposeTheme(darkTheme = true) {
        MainScreen()
    }
}