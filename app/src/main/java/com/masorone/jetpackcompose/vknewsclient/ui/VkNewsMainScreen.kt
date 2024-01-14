package com.masorone.jetpackcompose.vknewsclient.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DismissDirection
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SwipeToDismiss
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDismissState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.masorone.jetpackcompose.ui.CustomPreview
import com.masorone.jetpackcompose.ui.theme.JetpackComposeTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun VkNewsMainScreen(viewModel: VkNewsViewModel) {
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
        val items = viewModel.feedPostState().observeAsState(listOf())
        LazyColumn(
            contentPadding = PaddingValues(
                start = 8.dp,
                end = 8.dp,
                top = it.calculateTopPadding(),
                bottom = it.calculateBottomPadding() + 8.dp
            ),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(items.value, key = { feedPost -> feedPost.id }) { feedPost ->
                val dismissState = rememberDismissState(
                    positionalThreshold = { 156.dp.toPx() },
                )
                if (dismissState.isDismissed(DismissDirection.EndToStart)) {
                    viewModel.deleteItemBy(feedPost)
                }
                SwipeToDismiss(
                    modifier = Modifier.animateItemPlacement(),
                    state = dismissState,
                    directions = setOf(DismissDirection.EndToStart),
                    background = {
                        Box(
                            modifier = Modifier
                                .padding(16.dp)
                                .clip(RoundedCornerShape(16.dp))
                                .background(Color.Red)
                                .fillMaxSize(),
                            contentAlignment = Alignment.CenterEnd
                        ) {
                            Text(
                                text = "Delete",
                                modifier = Modifier.padding(end = 16.dp),
                                color = Color.White,
                                fontSize = 32.sp,
                                fontStyle = FontStyle.Italic
                            )
                        }
                    },
                    dismissContent = {
                        PostCard(
                            feedPost = feedPost,
                            onViewsItemClick = { viewModel.incrementStatisticValueBy(feedPost, it) },
                            onSharesItemClick = { viewModel.incrementStatisticValueBy(feedPost, it) },
                            onCommentsItemClick = { viewModel.incrementStatisticValueBy(feedPost, it) },
                            onLikesItemClick = { viewModel.incrementStatisticValueBy(feedPost, it) },
                        )
                    }
                )
            }
        }
    }
}

@Composable
@CustomPreview
fun VkNewsMainScreenLight() {
    JetpackComposeTheme(darkTheme = false) {
        VkNewsMainScreen(VkNewsViewModel())
    }
}

@Composable
@CustomPreview
fun VkNewsMainScreenDark() {
    JetpackComposeTheme(darkTheme = true) {
        VkNewsMainScreen(VkNewsViewModel())
    }
}