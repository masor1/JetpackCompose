package com.masorone.jetpackcompose.vknewsclient.ui.navigation

import android.net.Uri

fun String.encode(): String = Uri.encode(this)