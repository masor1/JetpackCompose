package com.masorone.jetpackcompose.vknewsclient.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vk.api.sdk.VK
import com.vk.api.sdk.auth.VKAuthenticationResult

class MainViewModel : ViewModel() {

    private val _state = MutableLiveData<State>(State.Initial)
    val state: LiveData<State> = _state

    init {
        _state.value = if (VK.isLoggedIn()) State.Authorized else State.NotAuthorized
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