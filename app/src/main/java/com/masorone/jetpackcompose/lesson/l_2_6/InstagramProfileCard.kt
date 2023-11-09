package com.masorone.jetpackcompose.lesson.l_2_6

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
fun InstagramProfileCardLight() {
    JetpackComposeTheme(
        darkTheme = false
    ) {
        InstagramProfileCard()
    }
}

@Preview(showBackground = true)
@Composable
fun InstagramProfileCardDark() {
    JetpackComposeTheme(
        darkTheme = true
    ) {
        InstagramProfileCard()
    }
}

@Composable
fun AccountTopContent() {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        AccountIcon()
        AccountInfoItem()
        AccountInfoItem()
        AccountInfoItem()
    }
}

@Composable
fun AccountIcon() {
    Box(
        modifier = Modifier
            .size(50.dp)
            .border(BorderStroke(2.dp, Color.Yellow))
    ) {

    }
}

@Composable
fun AccountInfoItem() {
    Column(
        Modifier
            .height(80.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Box(
            modifier = Modifier
                .size(25.dp)
                .border(BorderStroke(2.dp, Color.Yellow))
        ) {

        }
        Box(
            modifier = Modifier
                .size(25.dp)
                .border(BorderStroke(2.dp, Color.Yellow))
        ) {

        }
    }
}