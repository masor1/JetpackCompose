package com.masorone.jetpackcompose.vknewsclient.presentation.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vk.api.sdk.VK
import com.vk.api.sdk.VKPreferencesKeyValueStorage
import com.vk.api.sdk.auth.VKAccessToken
import com.vk.api.sdk.auth.VKAuthenticationResult

class MainViewModel(
    private val application: Application
) : AndroidViewModel(application) {

    private val _state = MutableLiveData<State>(State.Initial)
    val state: LiveData<State> = _state

    init {
        val storage = VKPreferencesKeyValueStorage(application)
        val token = VKAccessToken.restore(storage)
        val isLoggedIn = token != null && token.isValid
        _state.value = if (isLoggedIn) State.Authorized else State.NotAuthorized
    }

    fun performAuth(result: VKAuthenticationResult) {
        _state.value = if (result is VKAuthenticationResult.Success) {
            State.Authorized
        } else {
            State.NotAuthorized
        }
    }

    sealed interface State {
        object Initial : State
        object Authorized : State
        object NotAuthorized : State
    }
}