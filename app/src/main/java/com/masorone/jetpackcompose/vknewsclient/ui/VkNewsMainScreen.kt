package com.masorone.jetpackcompose.vknewsclient.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.masorone.jetpackcompose.ui.CustomPreview
import com.masorone.jetpackcompose.ui.theme.JetpackComposeTheme
import com.masorone.jetpackcompose.vknewsclient.domain.FeedPost
import com.masorone.jetpackcompose.vknewsclient.domain.StatisticType

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VkNewsMainScreen() {
    val feedPostState = rememberSaveable {
        mutableStateOf(FeedPost())
    }
    Scaffold(
        bottomBar = {
            NavigationBar {
                val selectedPositionState = remember { mutableIntStateOf(0) }
                val navigationItems = listOf(
                    NavigationItem.Home,
                    NavigationItem.Favourite,
                    NavigationItem.Profile
                )
                navigationItems.forEachIndexed { position, navigationItem ->
                    navigationItem.Show(position == selectedPositionState.intValue) {
                        selectedPositionState.intValue = position
                    }
                }
            }
        }
    ) {
        PostCard(
            feedPostState = feedPostState,
            onViewsItemClick = {
                feedPostState.incrementStatisticValueBy(StatisticType.VIEWS)
            },
            onSharesItemClick = {
                feedPostState.incrementStatisticValueBy(StatisticType.SHARES)
            },
            onCommentsItemClick = {
                feedPostState.incrementStatisticValueBy(StatisticType.COMMENT)
            },
            onLikesItemClick = {
                feedPostState.incrementStatisticValueBy(StatisticType.LIKES)
            },
            modifier = Modifier
                .padding(it)
                .padding(8.dp)
        )
    }
}

private fun MutableState<FeedPost>.incrementStatisticValueBy(type: StatisticType) {
    value = value.copy(statistics = value.statistics.map {
        if (it.type == type) {
            it.copy(count = it.count + 1)
        } else {
            it
        }
    })
}

@Composable
@CustomPreview
fun VkNewsMainScreenLight() {
    JetpackComposeTheme(darkTheme = false) {
        VkNewsMainScreen()
    }
}

@Composable
@CustomPreview
fun VkNewsMainScreenDark() {
    JetpackComposeTheme(darkTheme = true) {
        VkNewsMainScreen()
    }
}