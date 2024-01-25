package com.masorone.custom.sample

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp

@Composable
fun Samples10_1_10_2() {
    Canvas(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(Color.Cyan, Color.Magenta),
                    end = Offset(20.toDpToPx(), 20.toDpToPx()),
                    tileMode = TileMode.Mirror
                )
            )
    ) {
        drawPath(
            path = Path().apply {
                moveTo(center.x, 100.dp.toPx())
                lineTo(center.x + 25.dp.toPx(), 150.dp.toPx())
                lineTo(center.x + 75.dp.toPx(), 150.dp.toPx())
                lineTo(center.x + 45.dp.toPx(), 195.dp.toPx())
                lineTo(center.x + 60.dp.toPx(), 250.dp.toPx())
                lineTo(center.x, 220.dp.toPx())
                lineTo(center.x - 60.dp.toPx(), 250.dp.toPx())
                lineTo(center.x - 45.dp.toPx(), 195.dp.toPx())
                lineTo(center.x - 75.dp.toPx(), 150.dp.toPx())
                lineTo(center.x - 25.dp.toPx(), 150.dp.toPx())
                lineTo(center.x, 100.dp.toPx())
            },
            brush = Brush.linearGradient(
                colors = listOf(Color.Cyan, Color.Magenta),
                end = Offset(-20.dp.toPx(), 20.dp.toPx()),
                tileMode = TileMode.Mirror
            ),
            style = Fill
        )
        drawPath(
            path = Path().apply {
                moveTo(center.x, 100.dp.toPx())
                lineTo(center.x + 25.dp.toPx(), 150.dp.toPx())
                lineTo(center.x + 75.dp.toPx(), 150.dp.toPx())
                lineTo(center.x + 45.dp.toPx(), 195.dp.toPx())
                lineTo(center.x + 60.dp.toPx(), 250.dp.toPx())
                lineTo(center.x, 220.dp.toPx())
                lineTo(center.x - 60.dp.toPx(), 250.dp.toPx())
                lineTo(center.x - 45.dp.toPx(), 195.dp.toPx())
                lineTo(center.x - 75.dp.toPx(), 150.dp.toPx())
                lineTo(center.x - 25.dp.toPx(), 150.dp.toPx())
                lineTo(center.x, 100.dp.toPx())
            },
            brush = Brush.linearGradient(
                colors = listOf(Color.Cyan, Color.Magenta),
                end = Offset(-20.dp.toPx(), 20.dp.toPx()),
                tileMode = TileMode.Mirror
            ),
            style = Fill
        )
        drawCircle(Color.Cyan, radius = 5f)
        drawPath(
            path = Path().apply {
                moveTo(center.x - 40.dp.toPx(), center.y - 40.dp.toPx())
                lineTo(center.x - 40.dp.toPx(), center.y + 40.dp.toPx())
                lineTo(center.x + 40.dp.toPx(), center.y + 40.dp.toPx())
                lineTo(center.x + 40.dp.toPx(), center.y - 40.dp.toPx())
                lineTo(center.x - 40.dp.toPx(), center.y - 40.dp.toPx())

                moveTo(center.x, center.y - 40.dp.toPx())
                lineTo(center.x, center.y + 40.dp.toPx())
                moveTo(center.x - 40.dp.toPx(), center.y)
                lineTo(center.x + 40.dp.toPx(), center.y)

                moveTo(center.x - 80.dp.toPx(), center.y - 80.dp.toPx())
                lineTo(center.x - 80.dp.toPx(), center.y + 80.dp.toPx())
                lineTo(center.x + 80.dp.toPx(), center.y + 80.dp.toPx())
                lineTo(center.x + 80.dp.toPx(), center.y - 80.dp.toPx())
                lineTo(center.x - 80.dp.toPx(), center.y - 80.dp.toPx())
                lineTo(center.x, center.y - 150.dp.toPx())
                lineTo(center.x + 80.dp.toPx(), center.y - 80.dp.toPx())
            },
            color = Color.White,
            style = Stroke(2.dp.toPx())
        )
    }
}