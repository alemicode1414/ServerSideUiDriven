package com.example.alemitraining

import androidx.lifecycle.viewModelScope
import com.example.alemitraining.ui.model.UiState
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class TestRepository constructor(private val dispatcher: CoroutineDispatcher = IO) {

    private val _uiState = MutableStateFlow<UiState<String>>(UiState.Failure(RuntimeException()))
    val uiState = _uiState.asStateFlow()

    init {
        getMerchantDetails()
    }

    fun getMerchantDetails() = CoroutineScope(dispatcher).launch {
        _uiState.value = UiState.Success("1")

    }
}