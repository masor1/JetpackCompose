package com.masorone.jetpackcompose.vknewsclient.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.masorone.jetpackcompose.ui.CustomPreview
import com.masorone.jetpackcompose.ui.theme.JetpackComposeTheme

@Composable
fun VkNewsMainScreen(viewModel: VkNewsViewModel) {
    val selectedNavItem by viewModel.selectedNavItem().observeAsState(NavigationItem.Home)

    Scaffold(
        bottomBar = {
            NavigationBar {
                val navigationItems = listOf(
                    NavigationItem.Home,
                    NavigationItem.Favourite,
                    NavigationItem.Profile
                )
                navigationItems.forEach { navItem ->
                    navItem.Show(navItem == selectedNavItem) {
                        viewModel.selectNavItem(navItem)
                    }
                }
            }
        }
    ) { paddingValues ->
        when (selectedNavItem) {
            NavigationItem.Home -> HomeScreen(
                viewModel = viewModel,
                paddingValues = paddingValues
            )

            NavigationItem.Favourite -> TextCounter("Favourite")

            NavigationItem.Profile -> TextCounter("Profile")
        }
    }
}

@Composable
private fun TextCounter(text: String) {
    var count by remember {
        mutableIntStateOf(0)
    }
    Text(
        text = "$text Count: $count",
        fontSize = 42.sp,
        modifier = Modifier
            .fillMaxSize()
            .clickable {
                count++
            }
    )
}

@Composable
@CustomPreview
fun VkNewsMainScreenLight() {
    JetpackComposeTheme(darkTheme = false) {
        VkNewsMainScreen(VkNewsViewModel())
    }
}

@Composable
@CustomPreview
fun VkNewsMainScreenDark() {
    JetpackComposeTheme(darkTheme = true) {
        VkNewsMainScreen(VkNewsViewModel())
    }
}