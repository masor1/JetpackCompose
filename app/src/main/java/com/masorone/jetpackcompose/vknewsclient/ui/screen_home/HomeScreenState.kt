package com.masorone.jetpackcompose.vknewsclient.ui.screen_home

import com.masorone.jetpackcompose.vknewsclient.domain.FeedPost
import com.masorone.jetpackcompose.vknewsclient.domain.PostComment

sealed interface HomeScreenState {
    object Initial : HomeScreenState
    data class Posts(val posts: List<FeedPost>) : HomeScreenState
    data class Comments(val feedPost: FeedPost, val comments: List<PostComment>) : HomeScreenState
}