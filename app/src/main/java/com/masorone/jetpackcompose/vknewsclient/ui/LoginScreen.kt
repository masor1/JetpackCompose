package com.masorone.jetpackcompose.vknewsclient.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.masorone.jetpackcompose.R
import com.masorone.jetpackcompose.ui.CustomPreview
import com.masorone.jetpackcompose.ui.theme.Black
import com.masorone.jetpackcompose.ui.theme.DarkBlue
import com.masorone.jetpackcompose.ui.theme.JetpackComposeTheme
import com.masorone.jetpackcompose.ui.theme.White

@Composable
fun LoginScreen(
    onLoginClick: () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize()
            .background(if (isSystemInDarkTheme()) Black else White)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier.weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    modifier = Modifier.size(150.dp),
                    painter = painterResource(id = R.drawable.ic_vk_logo),
                    contentDescription = null
                )
            }
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = DarkBlue,
                    contentColor = White
                ),
                onClick = onLoginClick
            ) {
                Text(text = stringResource(R.string.text_login_screen_button_login))
            }
        }
    }
}

@CustomPreview
@Composable
fun LoginScreenLight() {
    JetpackComposeTheme(darkTheme = false) {
        LoginScreen {}
    }
}

@CustomPreview
@Composable
fun LoginScreenDark() {
    JetpackComposeTheme(darkTheme = true) {
        LoginScreen {}
    }
}