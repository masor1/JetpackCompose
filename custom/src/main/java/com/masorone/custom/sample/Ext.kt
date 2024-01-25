package com.masorone.custom.sample

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp

@Composable
fun Int.toDpToPx() = with(LocalDensity.current) {
    this@toDpToPx.dp.toPx()
}