package com.masorone.jetpackcompose.lesson.l_4_2_instagram_profile_card_view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class InstagramProfileCardViewModel : ViewModel() {

    private val initialList = mutableListOf<InstagramModel>().apply {
        repeat(500) {
            add(
                InstagramModel(
                    id = it,
                    title = "Titile $it",
                    isFollowed = Random.nextBoolean()
                )
            )
        }
    }

    private val _instagramModels = MutableLiveData<List<InstagramModel>>(initialList)

    fun instagramModels(): LiveData<List<InstagramModel>> = _instagramModels

    fun changeFollowing(id: Int) {
        val modifiedList = _instagramModels.value?.toMutableList() ?: mutableListOf()
        modifiedList.replaceAll {
            if (id == it.id)
                it.copy(isFollowed = it.isFollowed.not())
            else
                it
        }
        _instagramModels.value = modifiedList
    }

    fun deleteItemBy(model: InstagramModel) {
        val modifiedList = _instagramModels.value?.toMutableList() ?: mutableListOf()
        modifiedList.remove(model)
        _instagramModels.value = modifiedList
    }
}