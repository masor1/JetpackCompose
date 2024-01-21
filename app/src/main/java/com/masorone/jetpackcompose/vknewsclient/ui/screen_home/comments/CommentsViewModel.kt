package com.masorone.jetpackcompose.vknewsclient.ui.screen_home.comments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.masorone.jetpackcompose.vknewsclient.domain.FeedPost
import com.masorone.jetpackcompose.vknewsclient.domain.PostComment

class CommentsViewModel : ViewModel() {

    private val _screenState: MutableLiveData<CommentsScreenState> = MutableLiveData(CommentsScreenState.Initial)
    val screenState: LiveData<CommentsScreenState> = _screenState

    init {
        showComments(FeedPost(0))
    }

    fun showComments(feedPost: FeedPost) {
        _screenState.value = CommentsScreenState.Comments(
            feedPost = feedPost,
            comments = mutableListOf<PostComment>().apply {
                repeat(25) {
                    add(
                        PostComment(it)
                    )
                }
            }
        )
    }
}