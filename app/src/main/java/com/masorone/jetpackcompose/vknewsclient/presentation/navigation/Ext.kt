package com.masorone.jetpackcompose.vknewsclient.presentation.navigation

import android.net.Uri
import android.os.Build
import android.os.Bundle

fun String.encode(): String = Uri.encode(this)

fun <T> Bundle.getParcelableCompat(key: String, clazz: Class<T>) =
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        getParcelable(key, clazz)
    } else {
        getParcelable(key)
    } ?: throw RuntimeException("Args is null for class ${clazz.simpleName}")