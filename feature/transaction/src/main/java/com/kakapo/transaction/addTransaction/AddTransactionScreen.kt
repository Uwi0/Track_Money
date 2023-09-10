package com.kakapo.transaction.addTransaction

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
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
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.kakapo.common.type.FunUnit
import com.kakapo.designsystem.component.textfield.ClickAbleCustomTextFieldWithIcon
import com.kakapo.designsystem.component.textfield.CustomTextFieldWithIcon
import com.kakapo.designsystem.component.topAppBar.ContentActionTopAppBar
import com.kakapo.designsystem.component.topAppBar.NavigationTopAppBarWithTwoAction
import com.kakapo.designsystem.theme.AppTheme
import com.kakapo.transaction.R
import com.kakapo.ui.DevicePreview

@Composable
internal fun AddTransactionRoute() {
    AddTransactionScreen()
}

@Composable
internal fun AddTransactionScreen() {
    Scaffold(
        topBar = {
            AddTransactionTopAppbar(
                onBack = {},
                onAttachImage = {},
                onSave = {}
            )
        },
        content = {
            Column(
                modifier = Modifier.padding(it),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                CustomTextFieldWithIcon(
                    query = "",
                    placeholder = stringResource(id = R.string.description),
                    icon = Icons.Default.Notes,
                    onQueryChange = {}
                )
                ClickAbleCustomTextFieldWithIcon(
                    query = "",
                    placeholder = stringResource(id = R.string.category),
                    icon = Icons.Default.Category,
                    onClick = {}
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
        AddTransactionScreen()
    }
}