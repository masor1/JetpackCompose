package com.masorone.custom.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.masorone.custom.data.ApiFactory
import com.masorone.custom.data.Bar
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainCustomViewModel(
    private val apiFactory: ApiFactory = ApiFactory
) : ViewModel() {

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        Log.d("MainCustomViewModel", "$throwable")
    }

    private val _state = MutableStateFlow<State>(State.Initial)
    val state = _state.asStateFlow()

    init {
        loadBarList()
    }

    private fun loadBarList() {
        viewModelScope.launch(exceptionHandler) {
            val barList = apiFactory.apiService().loadBars().barList
            _state.value = State.Content(barList)
        }
    }

    sealed interface State {

        data object Initial : State

        data class Content(val barList: List<Bar>) : State
    }
}