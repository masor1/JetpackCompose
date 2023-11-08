package com.masorone.jetpackcompose.lesson.l_2_4

import android.content.res.Configuration
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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(
    device = "id:pixel",
    showBackground = true,
    showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
fun InstagramProfileCard() {
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