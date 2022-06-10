package com.miniclip.car

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {
    val uiState = MutableStateFlow<MainActivityEvent?>(null)

    var route by mutableStateOf("")
    var isLoading by mutableStateOf(true)

    sealed class MainActivityEvent {
        object InitAppEvent : MainActivityEvent()
    }
}