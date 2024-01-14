package com.masorone.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DismissDirection
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SwipeToDismiss
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDismissState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.masorone.jetpackcompose.lesson.l_4_2_instagram_profile_card_view_model.InstagramProfileCard
import com.masorone.jetpackcompose.lesson.l_4_2_instagram_profile_card_view_model.InstagramProfileCardViewModel
import com.masorone.jetpackcompose.ui.theme.JetpackComposeTheme
import com.masorone.jetpackcompose.vknewsclient.ui.VkNewsMainScreen
import com.masorone.jetpackcompose.vknewsclient.ui.VkNewsViewModel

class MainActivity : ComponentActivity() {

    private val instagramProfileCardViewModel by viewModels<InstagramProfileCardViewModel>()
    private val vkNewsViewModel by viewModels<VkNewsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                VkNewsMainScreen(vkNewsViewModel)
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun Main() {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            val models = instagramProfileCardViewModel.instagramModels().observeAsState(listOf())
            LazyColumn {
                items(items = models.value, key = { it.id }) { model ->
                    val dismissState = rememberDismissState(
                        positionalThreshold = { 156.dp.toPx() },
                    )
                    if (dismissState.isDismissed(DismissDirection.EndToStart)) {
                        instagramProfileCardViewModel.deleteItemBy(model)
                    }
                    SwipeToDismiss(
                        state = dismissState,
                        directions = setOf(DismissDirection.EndToStart),
                        background = {
                            Box(
                                modifier = Modifier
                                    .padding(16.dp)
                                    .clip(RoundedCornerShape(16.dp))
                                    .background(Color.Red)
                                    .fillMaxSize(),
                                contentAlignment = Alignment.CenterEnd
                            ) {
                                Text(
                                    text = "Delete",
                                    modifier = Modifier.padding(end = 16.dp),
                                    color = Color.White,
                                    fontSize = 32.sp,
                                    fontStyle = FontStyle.Italic
                                )
                            }
                        },
                        dismissContent = {
                            InstagramProfileCard(
                                model = model,
                                onFollowClick = {
                                    instagramProfileCardViewModel.changeFollowing(it)
                                }
                            )
                        }
                    )
                }
            }
        }
    }
}