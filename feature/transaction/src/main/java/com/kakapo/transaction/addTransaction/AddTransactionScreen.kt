package com.kakapo.transaction.addTransaction

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.AttachFile
import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.ContentPaste
import androidx.compose.material.icons.filled.Flag
import androidx.compose.material.icons.filled.Notes
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Today
import androidx.compose.material.icons.filled.Wallet
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.kakapo.common.type.FunUnit
import com.kakapo.designsystem.component.button.CustomTextButton
import com.kakapo.designsystem.component.textfield.ClickAbleCustomTextFieldWithIcon
import com.kakapo.designsystem.component.textfield.CustomTextFieldWithIcon
import com.kakapo.designsystem.component.topAppBar.ContentActionTopAppBar
import com.kakapo.designsystem.component.topAppBar.NavigationTopAppBarWithTwoAction
import com.kakapo.designsystem.theme.AppTheme
import com.kakapo.model.arguments.TransactionArguments
import com.kakapo.transaction.R
import com.kakapo.ui.DevicePreview

@Composable
internal fun AddTransactionRoute(
    viewModel: AddTransactionViewModel = hiltViewModel(),
    onNavigateToCalculator: FunUnit,
    onNavigateToPickACategory: FunUnit,
    saveStateHandle: SavedStateHandle
) {
    val amount = saveStateHandle.get<String>(TransactionArguments.EXPENSE)
    viewModel.setAmount(amount)
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val uiEvent = rememberAddTransactionEventState(viewModel = viewModel)

    LaunchedEffect(key1 = Unit) {
        viewModel.uiSideEffect.collect {
            when (it) {
                AddTransactionUiSideEffect.NavigateToCalculatorScreen -> {
                    onNavigateToCalculator.invoke()
                }

                AddTransactionUiSideEffect.NavigateToPickACategory -> {
                    onNavigateToPickACategory.invoke()
                }
            }
        }
    }

    AddTransactionScreen(uiState = uiState, onEvent = uiEvent::handleEvent)
}

@Composable
internal fun AddTransactionScreen(
    uiState: AddTransactionUiState,
    onEvent: (AddTransactionUiEvent) -> Unit
) {
    Scaffold(
        topBar = {
            AddTransactionTopAppbar(
                onBack = {},
                onAttachImage = {},
                onSave = {}
            )
        },
        content = { padding ->
            Column(
                modifier = Modifier
                    .padding(padding)
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                CustomTextButton(
                    onClick = {
                        val navigateToCalculator = AddTransactionUiEvent.NavigateToCalculatorScreen
                        onEvent.invoke(navigateToCalculator)
                    }
                ) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Rp ${uiState.amount}",
                        style = MaterialTheme.typography.displayMedium,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
                CustomTextFieldWithIcon(
                    query = uiState.description,
                    placeholder = stringResource(id = R.string.description),
                    icon = Icons.Default.Notes,
                    onQueryChange = { onEvent.invoke(AddTransactionUiEvent.InputDescription(it)) }
                )
                ClickAbleCustomTextFieldWithIcon(
                    query = "",
                    placeholder = stringResource(id = R.string.category),
                    icon = Icons.Default.Category,
                    onClick = { onEvent.invoke(AddTransactionUiEvent.NavigateToPickACategory) }
                )
                ClickAbleCustomTextFieldWithIcon(
                    query = "Today",
                    placeholder = "",
                    icon = Icons.Default.Today,
                    onClick = {}
                )
                ClickAbleCustomTextFieldWithIcon(
                    query = "",
                    placeholder = stringResource(id = R.string.wallet),
                    icon = Icons.Default.Wallet,
                    onClick = {}
                )
                ClickAbleCustomTextFieldWithIcon(
                    query = "",
                    placeholder = stringResource(id = R.string.event),
                    icon = Icons.Default.Flag,
                    onClick = {}
                )
                ClickAbleCustomTextFieldWithIcon(
                    query = "",
                    placeholder = stringResource(id = R.string.people),
                    icon = Icons.Default.People,
                    onClick = {}
                )
                ClickAbleCustomTextFieldWithIcon(
                    query = "",
                    placeholder = stringResource(id = R.string.place),
                    icon = Icons.Default.Place,
                    onClick = {}
                )
                CustomTextFieldWithIcon(
                    query = "",
                    placeholder = stringResource(id = R.string.note),
                    icon = Icons.Default.ContentPaste,
                    onQueryChange = {}
                )
            }
        }
    )
}

@Composable
private fun AddTransactionTopAppbar(
    onBack: FunUnit,
    onAttachImage: FunUnit,
    onSave: FunUnit
) {
    val topAppBar = ContentActionTopAppBar(
        navigationIcon = Icons.Default.ArrowBack,
        title = stringResource(id = R.string.title_new_transaction),
        firstActionIcon = Icons.Default.AttachFile,
        secondActionIcon = Icons.Default.Check
    )
    NavigationTopAppBarWithTwoAction(
        appBar = topAppBar,
        onNavigate = onBack,
        onFirstAction = onAttachImage,
        onSecondAction = onSave
    )
}

@DevicePreview
@Composable
private fun AddTransactionScreenPrev() {
    AppTheme {
        AddTransactionScreen(
            uiState = AddTransactionUiState(),
            onEvent = {}
        )
    }
}