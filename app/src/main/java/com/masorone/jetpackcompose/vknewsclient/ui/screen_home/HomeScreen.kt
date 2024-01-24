package com.masorone.jetpackcompose.vknewsclient.ui.screen_home

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.masorone.jetpackcompose.vknewsclient.domain.FeedPost
import com.masorone.jetpackcompose.vknewsclient.ui.screen_home.comments.CommentsScreen
import com.masorone.jetpackcompose.vknewsclient.ui.screen_home.posts.PostsScreen

@Composable
fun HomeScreen(
    paddingValues: PaddingValues
) {
    val currentState = remember {
        mutableStateOf<FeedPost?>(null)
    }
    val stateValue = currentState.value
    if (stateValue == null) {
        PostsScreen(paddingValues = paddingValues) {
            currentState.value = it
        }
    } else {
        CommentsScreen(
            feedPost = stateValue,
            paddingValues = paddingValues
        ) {
            currentState.value = null
        }
        BackHandler {
            currentState.value = null
        }
    }
}