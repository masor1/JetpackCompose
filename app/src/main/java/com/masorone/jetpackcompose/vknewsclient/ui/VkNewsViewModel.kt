package com.masorone.jetpackcompose.vknewsclient.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.masorone.jetpackcompose.vknewsclient.domain.FeedPost
import com.masorone.jetpackcompose.vknewsclient.domain.StatisticType
import kotlin.random.Random

class VkNewsViewModel : ViewModel() {

    private val initialList = mutableListOf<FeedPost>().apply {
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

    private val _feedPostState = MutableLiveData(initialList.toList())

    fun feedPostState(): LiveData<List<FeedPost>> = _feedPostState

    fun incrementStatisticValueBy(feedPost: FeedPost, type: StatisticType) = with(_feedPostState) {
        val modifiedList = feedPost.statistics.toMutableList()
        val modifiedList2 = value?.toMutableList() ?: mutableListOf()
        modifiedList.replaceAll {
            if(it.type == type) {
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
        value = modifiedList2
    }

    fun deleteItemBy(feedPost: FeedPost) {
        val list = _feedPostState.value?.toMutableList()
        list?.remove(feedPost)
        _feedPostState.value = list
    }
}