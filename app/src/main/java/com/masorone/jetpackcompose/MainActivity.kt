package com.masorone.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.masorone.jetpackcompose.lesson.l_4_2_instagram_profile_card_view_model.InstagramProfileCard
import com.masorone.jetpackcompose.lesson.l_4_2_instagram_profile_card_view_model.InstagramProfileCardViewModel
import com.masorone.jetpackcompose.ui.theme.JetpackComposeTheme
import com.masorone.jetpackcompose.vknewsclient.ui.PostCard
import com.masorone.jetpackcompose.vknewsclient.ui.VkNewsViewModel

class MainActivity : ComponentActivity() {

    private val instagramProfileCardViewModel by viewModels<InstagramProfileCardViewModel>()
    private val vkNewsViewModel by viewModels<VkNewsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                Main()
            }
        }
    }

    @Composable
    private fun Main() {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            LazyColumn {
                item {
                    Text(
                        text = "Title",
                        modifier = Modifier.fillMaxWidth(),
                        fontSize = 34.sp,
                        fontFamily = FontFamily.Monospace,
                        textAlign = TextAlign.Center
                    )
                }
                items(100) {
                    if (it % 3 == 0)
                        PostCard(
                            feedPostStateLiveData = vkNewsViewModel.feedPostState(),
                            onViewsItemClick = vkNewsViewModel::incrementStatisticValueBy,
                            onSharesItemClick = vkNewsViewModel::incrementStatisticValueBy,
                            onCommentsItemClick = vkNewsViewModel::incrementStatisticValueBy,
                            onLikesItemClick = vkNewsViewModel::incrementStatisticValueBy,
                            modifier = Modifier.padding(8.dp)
                        )
                    else
                        InstagramProfileCard(instagramProfileCardViewModel)
                }
            }
        }
    }
}