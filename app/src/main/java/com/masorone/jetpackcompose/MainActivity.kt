package com.masorone.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import com.masorone.jetpackcompose.ui.theme.JetpackComposeTheme
import com.masorone.jetpackcompose.vknewsclient.ui.VkNewsMainScreen
import com.masorone.jetpackcompose.vknewsclient.ui.VkNewsViewModel

class MainActivity : ComponentActivity() {

    private val vkNewsViewModel by viewModels<VkNewsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.background)
                ) {
                    VkNewsMainScreen(vkNewsViewModel)
                }
            }
        }
    }
}