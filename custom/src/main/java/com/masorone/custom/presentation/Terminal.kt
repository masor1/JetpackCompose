package com.masorone.custom.presentation

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.TransformableState
import androidx.compose.foundation.gestures.transformable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.translate
import com.masorone.custom.data.Bar
import kotlin.math.roundToInt

private const val MIN_VISIBLE_BARS_COUNT = 20

@Composable
fun Terminal(
    bars: List<Bar>
) {
    var visibleBarsCount by remember {
        mutableIntStateOf(100)
    }
    var scrolledBy by remember {
        mutableFloatStateOf(0f)
    }
    var barWidth by remember {
        mutableFloatStateOf(0f)
    }
    var terminalWidth by remember {
        mutableFloatStateOf(0f)
    }
    val transformableState = TransformableState { zoomChange, panChange, _ ->
        visibleBarsCount = (visibleBarsCount / zoomChange).roundToInt().coerceIn(
            MIN_VISIBLE_BARS_COUNT,
            bars.size
        )
        scrolledBy = (scrolledBy + panChange.x).coerceIn(0f, (bars.size * barWidth) - terminalWidth)
    }
    Canvas(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .transformable(transformableState)
    ) {
        terminalWidth = size.width
        val maxPrice = bars.maxOf { it.high }
        val minPrice = bars.minOf { it.low }
        barWidth = size.width / visibleBarsCount
        val pixelPerPoint = size.height / (maxPrice - minPrice)
        translate(left = scrolledBy) {
            bars.forEachIndexed { index, bar ->
                val xOffset = size.width - (index * barWidth)
                drawLine(
                    color = Color.White,
                    start = Offset(xOffset, size.height - ((bar.low - minPrice) * pixelPerPoint)),
                    end = Offset(xOffset, size.height - ((bar.high - minPrice) * pixelPerPoint)),
                    strokeWidth = 1f
                )
                drawLine(
                    color = if (bar.open < bar.close) Color.Green else Color.Red,
                    start = Offset(xOffset, size.height - ((bar.open - minPrice) * pixelPerPoint)),
                    end = Offset(xOffset, size.height - ((bar.close - minPrice) * pixelPerPoint)),
                    strokeWidth = barWidth / 2
                )
            }
        }
    }
}