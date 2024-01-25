package com.masorone.custom.sample

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun CanvasTest() {
    Canvas(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        fedor()
    }
}

fun DrawScope.fedor() {
    drawCircle(
        color = Color.Cyan,
        radius = 20.dp.toPx(),
        center = Offset(70.dp.toPx(), 50.dp.toPx()),
        style = Stroke(2.dp.toPx())
    )
    drawLine(
        color = Color.Cyan,
        start = Offset(70.dp.toPx(), 30.dp.toPx()),
        end = Offset(70.dp.toPx(), 90.dp.toPx()),
        strokeWidth = 2.dp.toPx()
    )
    drawLine(
        color = Color.Cyan,
        start = Offset(100.dp.toPx(), 30.dp.toPx()),
        end = Offset(100.dp.toPx(), 90.dp.toPx()),
        strokeWidth = 2.dp.toPx()
    )
    drawLine(
        color = Color.Cyan,
        start = Offset(100.dp.toPx(), 30.dp.toPx()),
        end = Offset(120.dp.toPx(), 30.dp.toPx()),
        strokeWidth = 2.dp.toPx()
    )
    drawLine(
        color = Color.Cyan,
        start = Offset(100.dp.toPx(), 70.dp.toPx()),
        end = Offset(120.dp.toPx(), 70.dp.toPx()),
        strokeWidth = 2.dp.toPx()
    )
    drawLine(
        color = Color.Cyan,
        start = Offset(100.dp.toPx(), 90.dp.toPx()),
        end = Offset(120.dp.toPx(), 90.dp.toPx()),
        strokeWidth = 2.dp.toPx()
    )
    drawLine(
        color = Color.Cyan,
        start = Offset(130.dp.toPx(), 90.dp.toPx()),
        end = Offset(170.dp.toPx(), 90.dp.toPx()),
        strokeWidth = 2.dp.toPx()
    )
    drawLine(
        color = Color.Cyan,
        start = Offset(150.dp.toPx(), 30.dp.toPx()),
        end = Offset(140.dp.toPx(), 90.dp.toPx()),
        strokeWidth = 2.dp.toPx()
    )
    drawLine(
        color = Color.Cyan,
        start = Offset(150.dp.toPx(), 30.dp.toPx()),
        end = Offset(160.dp.toPx(), 90.dp.toPx()),
        strokeWidth = 2.dp.toPx()
    )
    drawRect(
        color = Color.Cyan,
        topLeft = Offset(180.dp.toPx(), 30.dp.toPx()),
        size = Size(20.dp.toPx(), 60.dp.toPx()),
        style = Stroke(2.dp.toPx())
    )
    drawLine(
        color = Color.Cyan,
        start = Offset(210.dp.toPx(), 30.dp.toPx()),
        end = Offset(210.dp.toPx(), 90.dp.toPx()),
        strokeWidth = 2.dp.toPx()
    )
    drawLine(
        color = Color.Cyan,
        start = Offset(210.dp.toPx(), 30.dp.toPx()),
        end = Offset(230.dp.toPx(), 30.dp.toPx()),
        strokeWidth = 2.dp.toPx()
    )
    drawLine(
        color = Color.Cyan,
        start = Offset(230.dp.toPx(), 30.dp.toPx()),
        end = Offset(230.dp.toPx(), 70.dp.toPx()),
        strokeWidth = 2.dp.toPx()
    )
    drawLine(
        color = Color.Cyan,
        start = Offset(230.dp.toPx(), 70.dp.toPx()),
        end = Offset(210.dp.toPx(), 70.dp.toPx()),
        strokeWidth = 2.dp.toPx()
    )
}