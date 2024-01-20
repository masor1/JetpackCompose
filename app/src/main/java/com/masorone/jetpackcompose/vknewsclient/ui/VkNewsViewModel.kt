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

    private val initialState2 = HomeScreenState.Comments(
        feedPost = FeedPost(0),
        comments = mutableListOf<PostComment>().apply {
            repeat(25) {
                add(
                    PostComment(it)
                )
            }
        }
    )

    private val _homeScreenState: MutableLiveData<HomeScreenState> = MutableLiveData(initialState)

    fun homeScreenState(): LiveData<HomeScreenState> = _homeScreenState

    fun incrementStatisticValueBy(feedPost: FeedPost, type: StatisticType) = with(_homeScreenState) {
        val modifiedList = feedPost.statistics.toMutableList()
        val modifiedList2 = (value as? HomeScreenState.Posts)?.posts?.toMutableList() ?: mutableListOf()
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
        value = HomeScreenState.Posts(modifiedList2)
    }

    fun deleteItemBy(feedPost: FeedPost) {
        val list = (_homeScreenState.value as? HomeScreenState.Posts)?.posts?.toMutableList() ?: mutableListOf()
        list.remove(feedPost)
        _homeScreenState.value = HomeScreenState.Posts(list)
    }
}