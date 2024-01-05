package com.masorone.jetpackcompose.lesson.l_3

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
@Preview
fun Samples() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val dialogState = remember { mutableStateOf(false) }
        Sample1(dialogState)
        Spacer(modifier = Modifier.height(32.dp))
        Sample2()
        Spacer(modifier = Modifier.height(32.dp))
        Sample3(dialogState)
    }
}

@Composable
private fun Sample1(dialogState: MutableState<Boolean>) {
    OutlinedButton(
        onClick = { dialogState.value = true },
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp)
    ) {
        Text(text = "Text")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun Sample2() {
    TextField(
        value = "Value",
        onValueChange = {},
        label = {
            Text(text = "Label")
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp)
    )
}

@Composable
private fun Sample3(dialogState: MutableState<Boolean>) {

    if (dialogState.value) {
        AlertDialog(
            onDismissRequest = { dialogState.value = false },
            title = { Text(text = "Are you sure") },
            text = { Text(text = "Do you want to delete this file?") },
            confirmButton = {
                Button(
                    onClick = {
                        dialogState.value = false
                    }
                ) {
                    Text(text = "Yes")
                }
            },
            dismissButton = {
                OutlinedButton(
                    onClick = {
                        dialogState.value = false
                    }
                ) {
                    Text(text = "No")
                }
            }
        )
    }
}