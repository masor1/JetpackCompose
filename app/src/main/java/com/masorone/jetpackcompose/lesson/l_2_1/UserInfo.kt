package com.masorone.jetpackcompose.lesson.l_2_1

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun UserInfo(name: String, age: Int) {
    Text(text = "Hello $name, you are $age years old")
}