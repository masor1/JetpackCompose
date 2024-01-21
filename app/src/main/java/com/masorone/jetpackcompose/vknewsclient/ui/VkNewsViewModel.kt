package com.masorone.jetpackcompose.vknewsclient.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.masorone.jetpackcompose.vknewsclient.domain.FeedPost
import com.masorone.jetpackcompose.vknewsclient.domain.PostComment
import com.masorone.jetpackcompose.vknewsclient.domain.StatisticType
import com.masorone.jetpackcompose.vknewsclient.ui.screen_home.HomeScreenState
import kotlin.random.Random

class VkNewsViewModel : ViewModel() {

    private val initialState = HomeScreenState.Posts(
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

    private val _homeScreenState: MutableLiveData<HomeScreenState> = MutableLiveData(initialState)
    private var savedScreenState: HomeScreenState? = initialState

    fun homeScreenState(): LiveData<HomeScreenState> = _homeScreenState

    fun incrementStatisticValueBy(feedPost: FeedPost, type: StatisticType) {
        val currentState = _homeScreenState.value
        if (currentState !is HomeScreenState.Posts) return
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
        _homeScreenState.value = HomeScreenState.Posts(modifiedList2)
    }

    fun deleteItemBy(feedPost: FeedPost) {
        val currentState = _homeScreenState.value
        if (currentState !is HomeScreenState.Posts) return
        val list = currentState.posts.toMutableList()
        list.remove(feedPost)
        _homeScreenState.value = HomeScreenState.Posts(list)
    }

    fun showComments(post: FeedPost) {
        savedScreenState = _homeScreenState.value
        _homeScreenState.value = HomeScreenState.Comments(
            feedPost = post,
            comments = mutableListOf<PostComment>().apply {
                repeat(25) {
                    add(
                        PostComment(it)
                    )
                }
            }
        )
    }

    fun closeComments() {
        _homeScreenState.value = savedScreenState
    }
}