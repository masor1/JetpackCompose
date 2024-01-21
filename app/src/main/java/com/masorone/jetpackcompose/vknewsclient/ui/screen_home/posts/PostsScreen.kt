package com.masorone.jetpackcompose.vknewsclient.ui.screen_home.posts

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
import androidx.compose.material3.SwipeToDismiss
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDismissState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.masorone.jetpackcompose.vknewsclient.domain.FeedPost
import com.masorone.jetpackcompose.vknewsclient.ui.VkNewsViewModel

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun PostsScreen(
    viewModel: VkNewsViewModel,
    posts: List<FeedPost>,
    paddingValues: PaddingValues
) {
    LazyColumn(
        contentPadding = PaddingValues(
            start = 8.dp,
            end = 8.dp,
            top = paddingValues.calculateTopPadding(),
            bottom = paddingValues.calculateBottomPadding() + 8.dp
        ),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(posts, key = { feedPost -> feedPost.id }) { feedPost ->
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
                        onCommentsItemClick = { viewModel.showComments(feedPost) },
                        onLikesItemClick = { viewModel.incrementStatisticValueBy(feedPost, it) },
                    )
                }
            )
        }
    }
}