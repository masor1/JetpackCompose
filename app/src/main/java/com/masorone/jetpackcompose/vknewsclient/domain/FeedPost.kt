package com.masorone.jetpackcompose.vknewsclient.domain

import android.os.Parcelable
import com.masorone.jetpackcompose.R
import kotlinx.parcelize.Parcelize
import kotlin.random.Random

@Parcelize
data class FeedPost(
    val id: Int,
    val communityName: String = "Community Name",
    val publicationDate: String = "12:33",
    val avatarResId: Int = R.drawable.ic_launcher_background,
    val contentText: String = "Default ${Random.nextInt(1, 100)}",
    val contentImageResId: Int = R.drawable.ic_launcher_background,
    val statistics: List<StatisticItem> = listOf(
        StatisticItem(StatisticType.VIEWS, 206),
        StatisticItem(StatisticType.SHARES, 123),
        StatisticItem(StatisticType.COMMENT, 11),
        StatisticItem(StatisticType.LIKES, 456),
    )
) : Parcelable
