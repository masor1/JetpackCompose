package com.masorone.jetpackcompose.vknewsclient.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import com.masorone.jetpackcompose.ui.CustomPreview
import com.masorone.jetpackcompose.ui.theme.JetpackComposeTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VkNewsMainScreen() {
    val hostState = remember { SnackbarHostState() }
    val fabState = remember { mutableStateOf(true) }
    val scope = rememberCoroutineScope()
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
        },
        floatingActionButton = {
            if (fabState.value) {
                FloatingActionButton(
                    onClick = {
                        scope.launch {
                            val snackbarResult = hostState.showSnackbar(
                                message = "This is Snackbar",
                                actionLabel = "Hide FAB",
                                duration = SnackbarDuration.Long
                            )
                            if (snackbarResult == SnackbarResult.ActionPerformed) {
                                fabState.value = false
                            }
                        }
                    }
                ) {
                    Icon(imageVector = Icons.Filled.Favorite, contentDescription = null)
                }
            }
        },
        snackbarHost = { SnackbarHost(hostState = hostState) }
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