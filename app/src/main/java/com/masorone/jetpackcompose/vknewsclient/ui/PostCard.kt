package com.masorone.jetpackcompose.vknewsclient.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.masorone.jetpackcompose.R
import com.masorone.jetpackcompose.ui.CustomPreview
import com.masorone.jetpackcompose.ui.theme.JetpackComposeTheme

@Composable
fun PostCard() {
    Card(
        modifier = Modifier
            .wrapContentHeight()
            .padding(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        )
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
        ) {
            PostHeader()
            Spacer(modifier = Modifier.height(8.dp))
            PostContent()
            Spacer(modifier = Modifier.height(8.dp))
            PostStatistics()
        }
    }
}

@Composable
private fun PostHeader() {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .size(56.dp)
                .clip(CircleShape),
            painter = ColorPainter(Color.Cyan),
            contentDescription = null
        )
        Column(
            modifier = Modifier
                .padding(start = 8.dp, end = 8.dp)
                .weight(1f),
        ) {
            Text(
                text = "Group name",
                color = MaterialTheme.colorScheme.onBackground,
                fontWeight = FontWeight.Medium
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "12:00",
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
private fun PostContent() {
    Text(text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce dignissim nec nibh.")
    Spacer(modifier = Modifier.height(8.dp))
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = null,
        contentScale = ContentScale.FillWidth,
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .clickable { }
    )
}

@Composable
private fun PostStatistics() {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(modifier = Modifier.weight(1f)) {
            StatisticItem("206", R.drawable.ic_views) {}
        }
        Row(
            modifier = Modifier.weight(1f),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            StatisticItem("206", R.drawable.ic_share) {}
            StatisticItem("11", R.drawable.ic_comment) {}
            StatisticItem("496", R.drawable.ic_like) {}
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
            Spacer(modifier = Modifier.width(4.dp))
            Icon(
                painter = painterResource(id = iconResId),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSecondary
            )
        }
    }
}

@Composable
@CustomPreview
private fun PostCardLight() {
    JetpackComposeTheme(darkTheme = false) {
        PostCard()
    }
}

@Composable
@CustomPreview
private fun PostCardDark() {
    JetpackComposeTheme(darkTheme = true) {
        PostCard()
    }
}