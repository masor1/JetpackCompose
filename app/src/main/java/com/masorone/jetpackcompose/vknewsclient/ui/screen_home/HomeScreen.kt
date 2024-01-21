package com.masorone.jetpackcompose.vknewsclient.ui.screen_home

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.masorone.jetpackcompose.vknewsclient.ui.screen_home.comments.CommentsScreen
import com.masorone.jetpackcompose.vknewsclient.ui.screen_home.posts.PostsScreen

@Composable
fun HomeScreen(
    paddingValues: PaddingValues
) {
    val currentState = remember {
        mutableStateOf(true)
    }
    if (currentState.value) {
        PostsScreen(paddingValues = paddingValues) {
            currentState.value = false
        }
    } else {
        CommentsScreen(paddingValues = paddingValues) {
            currentState.value = true
        }
        BackHandler {
            currentState.value = true
        }
    }
}