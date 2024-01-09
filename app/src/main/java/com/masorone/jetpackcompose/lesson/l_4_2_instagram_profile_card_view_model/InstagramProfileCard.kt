package com.masorone.jetpackcompose.lesson.l_4_2_instagram_profile_card_view_model

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.masorone.jetpackcompose.R
import com.masorone.jetpackcompose.ui.CustomPreview
import com.masorone.jetpackcompose.ui.theme.JetpackComposeTheme

@Composable
fun InstagramProfileCard(viewModel: InstagramProfileCardViewModel) {
    val isFollowed by viewModel.isFollowing.observeAsState(false)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(8.dp),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.onBackground),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        )
    ) {
        AccountTopContent(isFollowed = isFollowed) {
            viewModel.changeFollowing()
        }
    }
}

@Composable
private fun AccountTopContent(isFollowed: Boolean, onFollowClick: () -> Unit) {
    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_instagram),
                modifier = Modifier
                    .clip(CircleShape)
                    .background(Color.White),
                contentDescription = null
            )
            UserStatistics(title = "Posts", value = "6,950")
            UserStatistics(title = "Followers", value = "105M")
            UserStatistics(title = "Following", value = "650")
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, bottom = 4.dp)
        ) {
            Text(
                text = "Instagram",
                fontFamily = FontFamily.Cursive,
                fontSize = 28.sp
            )
            Text(
                text = "#YorsToMake",
                fontSize = 14.sp
            )
            Text(
                text = "www.facebook.com/emotionalhealth",
                fontSize = 14.sp
            )
            FollowButton(isFollowed = isFollowed) { onFollowClick() }
        }
    }
}

@Composable
fun FollowButton(
    isFollowed: Boolean,
    onFollowClick: () -> Unit
) {
    OutlinedButton(
        onClick = { onFollowClick() },
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isFollowed)
                Color.Cyan
            else
                MaterialTheme.colorScheme.primary
        )
    ) {
        Text(text = if (isFollowed) "Unfollow" else "Follow")
    }
}

@Composable
private fun UserStatistics(
    title: String,
    value: String
) {
    Column(
        modifier = Modifier.height(80.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(
            text = value,
            fontFamily = FontFamily.Cursive,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = title,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
@CustomPreview
private fun InstagramProfileCardLight() {
    JetpackComposeTheme(darkTheme = false) {
        InstagramProfileCard(InstagramProfileCardViewModel())
    }
}

@Composable
@CustomPreview
private fun InstagramProfileCardDark() {
    JetpackComposeTheme(darkTheme = true) {
        InstagramProfileCard(InstagramProfileCardViewModel())
    }
}