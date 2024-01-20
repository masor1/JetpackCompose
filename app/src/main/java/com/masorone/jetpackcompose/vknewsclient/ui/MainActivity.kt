package com.masorone.jetpackcompose.vknewsclient.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.masorone.jetpackcompose.lesson.l_4_2_instagram_profile_card_view_model.InstagramProfileCardViewModel
import com.masorone.jetpackcompose.ui.theme.JetpackComposeTheme

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
}