package com.masorone.jetpackcompose.vknewsclient.domain

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavType
import com.google.gson.Gson
import com.masorone.jetpackcompose.R
import com.masorone.jetpackcompose.vknewsclient.ui.navigation.getParcelableCompat
import kotlinx.parcelize.Parcelize
import kotlin.random.Random

@Parcelize
data class FeedPost(
    val id: Int,
    val communityName: String = "Community Name",
    val publicationDate: String = "12:33",
    val avatarResId: Int = R.drawable.ic_launcher_background,
    val contentText: String = "Content text / ${Random.nextInt(1, 100)}",
    val contentImageResId: Int = R.drawable.ic_launcher_background,
    val statistics: List<StatisticItem> = listOf(
        StatisticItem(StatisticType.VIEWS, 206),
        StatisticItem(StatisticType.SHARES, 123),
        StatisticItem(StatisticType.COMMENT, 11),
        StatisticItem(StatisticType.LIKES, 456),
    )
) : Parcelable {

    companion object {

        val NavType: NavType<FeedPost> = object : NavType<FeedPost>(false) {

            override fun get(bundle: Bundle, key: String) = bundle.getParcelableCompat(key, FeedPost::class.java)

            override fun parseValue(value: String): FeedPost = Gson().fromJson(value, FeedPost::class.java)

            override fun put(bundle: Bundle, key: String, value: FeedPost) {
                bundle.putParcelable(key, value)
            }
        }
    }
}
