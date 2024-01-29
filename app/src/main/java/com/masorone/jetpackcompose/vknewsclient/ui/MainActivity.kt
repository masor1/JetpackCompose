package com.masorone.jetpackcompose.vknewsclient.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.masorone.jetpackcompose.ui.theme.JetpackComposeTheme
import com.vk.api.sdk.VK
import com.vk.api.sdk.auth.VKScope

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                val viewModel: MainViewModel = viewModel()
                val state = viewModel.state.observeAsState(MainViewModel.State.Initial)

                val authLauncher = rememberLauncherForActivityResult(
                    contract = VK.getVKAuthActivityResultContract(),
                    onResult = viewModel::performAuth
                )

                when (state.value) {
                    is MainViewModel.State.Authorized -> MainScreen()
                    is MainViewModel.State.NotAuthorized -> LoginScreen { authLauncher.launch(listOf(VKScope.WALL)) }
                    is MainViewModel.State.Initial -> Unit
                }
            }
        }
    }
}