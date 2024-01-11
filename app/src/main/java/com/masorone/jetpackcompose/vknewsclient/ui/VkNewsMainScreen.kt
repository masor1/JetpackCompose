package com.masorone.jetpackcompose.vknewsclient.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.masorone.jetpackcompose.ui.CustomPreview
import com.masorone.jetpackcompose.ui.theme.JetpackComposeTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VkNewsMainScreen(viewModel: VkNewsViewModel) {
    Scaffold(
        bottomBar = {
            NavigationBar {
                val selectedPositionState = remember { mutableIntStateOf(0) }
                val navigationItems = listOf(
                    NavigationItem.Home,
                    NavigationItem.Favourite,
                    NavigationItem.Profile
                )
                navigationItems.forEachIndexed { position, navigationItem ->
                    navigationItem.Show(position == selectedPositionState.intValue) {
                        selectedPositionState.intValue = position
                    }
                }
            }
        }
    ) {
        PostCard(
            feedPostStateLiveData = viewModel.feedPostState(),
            onViewsItemClick = viewModel::incrementStatisticValueBy,
            onSharesItemClick = viewModel::incrementStatisticValueBy,
            onCommentsItemClick = viewModel::incrementStatisticValueBy,
            onLikesItemClick = viewModel::incrementStatisticValueBy,
            modifier = Modifier
                .padding(it)
                .padding(8.dp)
        )
    }
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