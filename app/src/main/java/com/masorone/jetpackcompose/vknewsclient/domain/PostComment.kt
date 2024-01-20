package com.masorone.jetpackcompose.vknewsclient.domain

import com.masorone.jetpackcompose.R
import kotlin.random.Random

data class PostComment(
    val id: Int,
    val authorName: String = "Author",
    val authorAvatarId: Int = R.drawable.ic_launcher_foreground,
    val commentText: String = "Comment text comment text comment text",
    val date: String = "${Random.nextInt(1, 12)}:${Random.nextInt(10, 59)}",
)
