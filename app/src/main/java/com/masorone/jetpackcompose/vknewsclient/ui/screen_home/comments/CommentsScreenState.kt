package com.masorone.jetpackcompose.vknewsclient.ui.screen_home.comments

import com.masorone.jetpackcompose.vknewsclient.domain.FeedPost
import com.masorone.jetpackcompose.vknewsclient.domain.PostComment

sealed interface CommentsScreenState {

    object Initial : CommentsScreenState

    data class Comments(val feedPost: FeedPost, val comments: List<PostComment>) : CommentsScreenState
}