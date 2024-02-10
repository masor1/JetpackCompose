package com.masorone.custom.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.masorone.custom.ui.theme.JetpackComposeTheme

class MainCustomActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                val viewModel: MainCustomViewModel = viewModel()
                val state = viewModel.state.collectAsState()
                when (val currentState = state.value) {
                    is MainCustomViewModel.State.Initial -> {
                        LoadingScreen()
                    }

                    is MainCustomViewModel.State.Content -> {
                        Terminal(currentState.barList)
                    }
                }
            }
        }
    }
}