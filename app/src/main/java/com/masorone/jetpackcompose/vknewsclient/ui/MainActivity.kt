package com.masorone.jetpackcompose.vknewsclient.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.compose.runtime.SideEffect
import com.masorone.jetpackcompose.ui.theme.JetpackComposeTheme
import com.vk.api.sdk.VK
import com.vk.api.sdk.auth.VKAuthenticationResult
import com.vk.api.sdk.auth.VKScope

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                val authLauncher = rememberLauncherForActivityResult(
                    contract = VK.getVKAuthActivityResultContract()
                ) { result ->
                    when (result) {
                        is VKAuthenticationResult.Success -> {
                            Log.d("MainActivity", "Success")
                        }

                        is VKAuthenticationResult.Failed -> {
                            Log.d("MainActivity", "Failed")
                        }
                    }
                }
                SideEffect {
                    authLauncher.launch(listOf(VKScope.WALL))
                }
                MainScreen()
            }
        }
    }
}