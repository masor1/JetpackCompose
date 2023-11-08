package com.masorone.jetpackcompose.lesson.l_2_3

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(
    device = "id:pixel",
    showSystemUi = true,
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
fun TimesTable() {
    Column(modifier = Modifier.fillMaxSize()) {
        repeat(9) { rowIndex ->
            TimesTableRow(rowIndex = rowIndex)
        }
    }
}

@Composable
fun ColumnScope.TimesTableRow(rowIndex: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .weight(1f)
    ) {
        repeat(9) { boxIndex ->
            TimesTableBoxItem(element = TimesTableElement(rowIndex, boxIndex))
        }
    }
}

@Composable
fun RowScope.TimesTableBoxItem(element: TimesTableElement) {
    val roundedCornerShape = RoundedCornerShape(12.dp)
    Box(
        modifier = Modifier
            .padding(2.dp)
            .background(element.background(), roundedCornerShape)
            .fillMaxHeight()
            .weight(1f)
            .border(
                BorderStroke(2.dp, Color.LightGray),
                roundedCornerShape
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(text = element.value())
    }
}

data class TimesTableElement(
    private val i: Int,
    private val j: Int,
) {

    fun background() = if (((i + j + 2) % 2) == 0) Color.Yellow else Color.White

    fun value() = ((i + 1) * (j + 1)).toString()
}