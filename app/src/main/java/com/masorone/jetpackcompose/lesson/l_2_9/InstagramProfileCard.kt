package com.masorone.jetpackcompose.lesson.l_2_9

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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.masorone.jetpackcompose.R
import com.masorone.jetpackcompose.ui.theme.JetpackComposeTheme

@Composable
fun InstagramProfileCard() {
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
        AccountTopContent()
    }
}

@Preview(showBackground = true)
@Composable
private fun InstagramProfileCardLight() {
    JetpackComposeTheme(
        darkTheme = false
    ) {
        InstagramProfileCard()
    }
}

@Preview(showBackground = true)
@Composable
private fun InstagramProfileCardDark() {
    JetpackComposeTheme(
        darkTheme = true
    ) {
        InstagramProfileCard()
    }
}

@Composable
private fun AccountTopContent() {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        AccountIcon()
        UserStatistics(title = "Posts", value = "6,950")
        UserStatistics(title = "Followers", value = "105M")
        UserStatistics(title = "Following", value = "650")
    }
}

@Composable
private fun AccountIcon() {
    Image(
        painter = painterResource(id = R.drawable.ic_instagram),
        modifier = Modifier
            .clip(CircleShape)
            .background(Color.White),
        contentDescription = ""
    )
}

@Composable
private fun UserStatistics(
    title: String,
    value: String
) {
    Column(
        Modifier
            .height(80.dp),
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