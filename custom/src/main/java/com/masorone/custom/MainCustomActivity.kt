package com.masorone.custom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.masorone.custom.sample.CanvasTest
import com.masorone.custom.ui.theme.JetpackComposeTheme

class MainCustomActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                CanvasTest()
            }
        }
    }
}