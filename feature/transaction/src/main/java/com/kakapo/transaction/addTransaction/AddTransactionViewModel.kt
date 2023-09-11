package com.kakapo.transaction.addTransaction

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class AddTransactionViewModel @Inject constructor(
    private val saveStateHandle: SavedStateHandle
) : ViewModel() {

    val uiState get() = _uiState.asStateFlow()
    private val _uiState = MutableStateFlow(AddTransactionUiState())
    fun setAmount(amount: String?) {
        saveStateHandle.apply {
            _uiState.update { it.copy(amount = amount ?: "0") }
        }
    }
}

data class AddTransactionUiState(
    val amount: String = "0",
)