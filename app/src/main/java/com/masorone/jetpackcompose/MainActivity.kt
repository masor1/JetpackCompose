package com.masorone.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.masorone.jetpackcompose.lesson.l_2_2.UserInfo

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UserInfo(name = "Fedor", age = 24)
        }
    }
}

@Composable
@Preview
fun Greeting() {
    Text(text = "Hello", color = Color.Blue)
}