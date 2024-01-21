package com.masorone.jetpackcompose.vknewsclient.ui.screen_home.posts

import com.masorone.jetpackcompose.vknewsclient.domain.FeedPost

sealed interface PostsScreenState {

    object Initial : PostsScreenState

    data class Posts(val posts: List<FeedPost>) : PostsScreenState
}