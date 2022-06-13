package com.miniclip.car

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class Maicomminiclipcarodel @Inject constructor() : ViewModel() {
    val uecomminiclipcarResulte = MutableStateFlow<MaincomminiclipcarEvent?>(null)

    var rcomminiclipcare by mutableStateOf("")

    fun onEcomminiclipcar(event: MaincomminiclipcarEvent.IncomminiclipcarEvent? = null) {
        uecomminiclipcarResulte.value = event
    }

    sealed class MaincomminiclipcarEvent {
        object IncomminiclipcarEvent : MaincomminiclipcarEvent()
    }
}