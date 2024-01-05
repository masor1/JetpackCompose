package com.masorone.jetpackcompose.vknewsclient.ui

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.masorone.jetpackcompose.ui.CustomPreview
import com.masorone.jetpackcompose.ui.theme.JetpackComposeTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VkNewsMainScreen() {
    Scaffold(
        bottomBar = {
            NavigationBar {
                val selectedPositionState = remember { mutableStateOf(0) }
                val navigationItems = listOf(
                    NavigationItem.Home,
                    NavigationItem.Favourite,
                    NavigationItem.Profile
                )
                navigationItems.forEachIndexed { position, navigationItem ->
                    navigationItem.Show(position == selectedPositionState.value) {
                        selectedPositionState.value = position
                    }
                }
            }
        }
    ) {
        it
    }
}

@Composable
@CustomPreview
fun VkNewsMainScreenLight() {
    JetpackComposeTheme(darkTheme = false) {
        VkNewsMainScreen()
    }
}

@Composable
@CustomPreview
fun VkNewsMainScreenDark() {
    JetpackComposeTheme(darkTheme = true) {
        VkNewsMainScreen()
    }
}