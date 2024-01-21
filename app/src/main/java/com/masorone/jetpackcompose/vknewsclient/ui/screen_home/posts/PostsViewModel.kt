package com.masorone.jetpackcompose.vknewsclient.ui.screen_home.posts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.masorone.jetpackcompose.vknewsclient.domain.FeedPost
import com.masorone.jetpackcompose.vknewsclient.domain.StatisticType
import kotlin.random.Random

class PostsViewModel : ViewModel() {

    private val initialState = PostsScreenState.Posts(
        mutableListOf<FeedPost>().apply {
            repeat(25) {
                add(
                    FeedPost(
                        id = it,
                        communityName = "Community Name $it",
                        publicationDate = "${Random.nextInt(1, 12)}:${Random.nextInt(0, 59)}"
                    )
                )
            }
        }
    )

    private val _screenState: MutableLiveData<PostsScreenState> = MutableLiveData(initialState)
    val screenState: LiveData<PostsScreenState> = _screenState

    fun incrementStatisticValueBy(feedPost: FeedPost, type: StatisticType) {
        val currentState = _screenState.value
        if (currentState !is PostsScreenState.Posts) return
        val modifiedList = feedPost.statistics.toMutableList()
        val modifiedList2 = currentState.posts.toMutableList()
        modifiedList.replaceAll {
            if (it.type == type) {
                it.copy(count = it.count + 1)
            } else {
                it
            }
        }
        modifiedList2.replaceAll {
            if (it == feedPost) {
                it.copy(statistics = modifiedList)
            } else {
                it
            }
        }
        _screenState.value = PostsScreenState.Posts(modifiedList2)
    }

    fun deleteItemBy(feedPost: FeedPost) {
        val currentState = _screenState.value
        if (currentState !is PostsScreenState.Posts) return
        val list = currentState.posts.toMutableList()
        list.remove(feedPost)
        _screenState.value = PostsScreenState.Posts(list)
    }
}