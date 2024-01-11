package com.masorone.jetpackcompose.vknewsclient.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.masorone.jetpackcompose.vknewsclient.domain.FeedPost
import com.masorone.jetpackcompose.vknewsclient.domain.StatisticType

class VkNewsViewModel : ViewModel() {

    private val _feedPostState = MutableLiveData(FeedPost())

    fun feedPostState(): LiveData<FeedPost> = _feedPostState

    fun incrementStatisticValueBy(type: StatisticType) = with(_feedPostState) {
        value = value?.copy(statistics = value?.statistics?.map {
            if (it.type == type) {
                it.copy(count = it.count + 1)
            } else {
                it
            }
        } ?: throw IllegalArgumentException("FeedPost don't be null in ${VkNewsViewModel::javaClass}"))
    }
}