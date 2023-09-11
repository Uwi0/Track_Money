package com.kakapo.transaction.addTransaction

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember

@Composable
fun rememberAddTransactionEventState(viewModel: AddTransactionViewModel): AddTransactionEventState {
    return remember { AddTransactionEventState(viewModel) }
}

class AddTransactionEventState(private val viewModel: AddTransactionViewModel) {

    fun handleEvent(event: AddTransactionUiEvent) {
        when (event) {
            is AddTransactionUiEvent.InputDescription -> {
                viewModel.updateDescription(event.description)
            }

            AddTransactionUiEvent.NavigateToCalculatorScreen -> {
                viewModel.emitSideEffect(AddTransactionUiSideEffect.NavigateToCalculatorScreen)
            }

            AddTransactionUiEvent.NavigateToPickACategory -> {
                viewModel.emitSideEffect(AddTransactionUiSideEffect.NavigateToPickACategory)
            }
        }
    }
}

data class AddTransactionUiState(
    val amount: String = "0",
    val description: String = ""
)

sealed interface AddTransactionUiSideEffect {
    data object NavigateToCalculatorScreen : AddTransactionUiSideEffect
    data object NavigateToPickACategory : AddTransactionUiSideEffect
}

sealed interface AddTransactionUiEvent {
    data class InputDescription(val description: String) : AddTransactionUiEvent
    data object NavigateToCalculatorScreen : AddTransactionUiEvent
    data object NavigateToPickACategory : AddTransactionUiEvent
}