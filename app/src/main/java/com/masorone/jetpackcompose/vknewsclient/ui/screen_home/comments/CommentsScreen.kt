package com.masorone.jetpackcompose.vknewsclient.ui.screen_home.comments

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.masorone.jetpackcompose.ui.CustomPreview
import com.masorone.jetpackcompose.ui.SpacerHeight
import com.masorone.jetpackcompose.ui.theme.JetpackComposeTheme
import com.masorone.jetpackcompose.vknewsclient.domain.FeedPost
import com.masorone.jetpackcompose.vknewsclient.domain.PostComment

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommentsScreen(
    feedPost: FeedPost,
    postComments: List<PostComment>,
    paddingValues: PaddingValues,
    onBackPressed: () -> Unit
) {
    Scaffold(
        modifier = Modifier.padding(paddingValues),
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Comments for post: ${feedPost.id}")
                },
                navigationIcon = {
                    IconButton(onClick = onBackPressed) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = null
                        )
                    }
                }
            )
        }
    ) { innerPaddingValues ->
        LazyColumn(
            contentPadding = innerPaddingValues
        ) {
            itemsIndexed(
                postComments,
                { _, comment -> comment.id }
            ) { index, comment ->
                CommentItem(comment = comment)
                if (index != postComments.size - 1)
                    Divider(Modifier.padding(horizontal = 16.dp))
            }
        }
    }
}

@Composable
private fun CommentItem(comment: PostComment) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
    ) {
        Icon(
            painter = painterResource(id = comment.authorAvatarId),
            contentDescription = null,
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
        )
        Column(
            modifier = Modifier.padding(horizontal = 8.dp)
        ) {
            SpacerHeight(dp = 4.dp)
            Text(
                text = "${comment.authorName}: ${comment.id}",
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.onSecondary
            )
            SpacerHeight(dp = 4.dp)
            Text(
                text = comment.commentText,
                fontSize = 14.sp
            )
            SpacerHeight(dp = 4.dp)
            Text(
                text = comment.date,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.End,
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.onSecondary
            )
            SpacerHeight(dp = 4.dp)
        }
    }
}

@Composable
@CustomPreview
fun CommentItemPreview() {
    JetpackComposeTheme {
        CommentItem(comment = PostComment(0))
    }
}