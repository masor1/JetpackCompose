package com.masorone.jetpackcompose.vknewsclient.ui.screen_home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import com.masorone.jetpackcompose.vknewsclient.ui.VkNewsViewModel
import com.masorone.jetpackcompose.vknewsclient.ui.screen_home.comments.CommentsScreen
import com.masorone.jetpackcompose.vknewsclient.ui.screen_home.posts.PostsScreen

@Composable
fun HomeScreen(
    viewModel: VkNewsViewModel,
    paddingValues: PaddingValues
) {
    val homeScreenState = viewModel.homeScreenState().observeAsState(HomeScreenState.Initial)
    when (val currentState = homeScreenState.value) {
        is HomeScreenState.Posts -> PostsScreen(
            viewModel = viewModel,
            posts = currentState.posts,
            paddingValues = paddingValues
        )

        is HomeScreenState.Comments -> CommentsScreen(
            feedPost = currentState.feedPost,
            postComments = currentState.comments,
            paddingValues = paddingValues
        )

        is HomeScreenState.Initial -> Unit
    }
}