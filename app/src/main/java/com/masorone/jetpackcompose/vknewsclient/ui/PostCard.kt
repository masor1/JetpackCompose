package com.masorone.jetpackcompose.vknewsclient.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.masorone.jetpackcompose.R
import com.masorone.jetpackcompose.ui.CustomPreview
import com.masorone.jetpackcompose.ui.SpacerHeight
import com.masorone.jetpackcompose.ui.SpacerWidth
import com.masorone.jetpackcompose.ui.theme.JetpackComposeTheme
import com.masorone.jetpackcompose.vknewsclient.domain.FeedPost
import com.masorone.jetpackcompose.vknewsclient.domain.StatisticItem
import com.masorone.jetpackcompose.vknewsclient.domain.StatisticType

@Composable
fun PostCard(
    feedPostState: State<FeedPost>,
    onViewsItemClick: (Int) -> Unit,
    onSharesItemClick: (Int) -> Unit,
    onCommentsItemClick: (Int) -> Unit,
    onLikesItemClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        )
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
        ) {
            PostHeader(feedPostState = feedPostState)
            SpacerHeight(8.dp)
            PostContent(feedPostState = feedPostState)
            SpacerHeight(8.dp)
            PostStatistics(
                feedPostState = feedPostState,
                onViewsItemClick = onViewsItemClick,
                onSharesItemClick = onSharesItemClick,
                onCommentsItemClick = onCommentsItemClick,
                onLikesItemClick = onLikesItemClick
            )
        }
    }
}

@Composable
private fun PostHeader(feedPostState: State<FeedPost>) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            modifier = Modifier
                .size(56.dp)
                .clip(CircleShape),
            painter = painterResource(id = feedPostState.value.avatarResId),
            contentDescription = null
        )
        Column(
            modifier = Modifier
                .padding(start = 8.dp, end = 8.dp)
                .weight(1f),
        ) {
            Text(
                text = feedPostState.value.communityName,
                color = MaterialTheme.colorScheme.onBackground,
                fontWeight = FontWeight.Medium
            )
            SpacerHeight(4.dp)
            Text(
                text = feedPostState.value.publicationDate,
                color = MaterialTheme.colorScheme.onSecondary
            )
        }
        Icon(
            imageVector = Icons.Filled.MoreVert,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onSecondary,
            modifier = Modifier
                .clip(CircleShape)
                .clickable { }
        )
    }
}

@Composable
private fun PostContent(feedPostState: State<FeedPost>) {
    Text(text = feedPostState.value.contentText)
    SpacerHeight(8.dp)
    Image(
        painter = painterResource(feedPostState.value.contentImageResId),
        contentDescription = null,
        contentScale = ContentScale.FillWidth,
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .clickable { }
    )
}

@Composable
private fun PostStatistics(
    feedPostState: State<FeedPost>,
    onViewsItemClick: (Int) -> Unit,
    onSharesItemClick: (Int) -> Unit,
    onCommentsItemClick: (Int) -> Unit,
    onLikesItemClick: (Int) -> Unit
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Row(modifier = Modifier.weight(1f)) {
            val viewsItem = feedPostState.value.statistics.itemBy(StatisticType.VIEWS)
            StatisticItem(
                count = viewsItem.count.toString(),
                iconResId = R.drawable.ic_views
            ) {
                onViewsItemClick(viewsItem.count)
            }
        }
        Row(
            modifier = Modifier.weight(1f),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            val sharesItem = feedPostState.value.statistics.itemBy(StatisticType.SHARES)
            val commentItem = feedPostState.value.statistics.itemBy(StatisticType.COMMENT)
            val likesItem = feedPostState.value.statistics.itemBy(StatisticType.LIKES)
            StatisticItem(
                count = sharesItem.count.toString(),
                iconResId = R.drawable.ic_share
            ) {
                onSharesItemClick(sharesItem.count)
            }
            StatisticItem(
                count = commentItem.count.toString(),
                iconResId = R.drawable.ic_comment
            ) {
                onCommentsItemClick(commentItem.count)
            }
            StatisticItem(
                count = likesItem.count.toString(),
                iconResId = R.drawable.ic_like
            ) {
                onLikesItemClick(likesItem.count)
            }
        }
    }
}

@Composable
private fun StatisticItem(
    count: String,
    iconResId: Int,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .clip(CircleShape)
            .clickable { onClick() }
    ) {
        Row(
            modifier = Modifier.padding(4.dp),
            verticalAlignment = Alignment.CenterVertically

        ) {
            Text(
                text = count,
                color = MaterialTheme.colorScheme.onSecondary
            )
            SpacerWidth(4.dp)
            Icon(
                painter = painterResource(id = iconResId),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSecondary
            )
        }
    }
}

private fun List<StatisticItem>.itemBy(type: StatisticType): StatisticItem = find {
    it.type == type
} ?: throw IllegalArgumentException("Type $type don't found in list of StatisticItem: $this")

@Composable
@CustomPreview
private fun PostCardLight() {
    val feedPostState = remember {
        mutableStateOf(FeedPost())
    }
    JetpackComposeTheme(darkTheme = false) {
        PostCard(feedPostState, {}, {}, {}, {})
    }
}

@Composable
@CustomPreview
private fun PostCardDark() {
    val feedPostState = remember {
        mutableStateOf(FeedPost())
    }
    JetpackComposeTheme(darkTheme = true) {
        PostCard(feedPostState, {}, {}, {}, {})
    }
}