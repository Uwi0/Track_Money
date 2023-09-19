package com.kakapo.ui.component.dialog

import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.kakapo.designsystem.component.button.CustomTextButton
import com.kakapo.designsystem.theme.AppTheme
import com.kakapo.ui.DevicePreview
import com.kakapo.ui.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomDialogSelectDate(onDismiss: () -> Unit, onSelected: (Long) -> Unit) {
    val state = rememberDatePickerState()
    DatePickerDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            CustomTextButton(
                onClick = { onSelected.invoke(state.selectedDateMillis ?: 0L) },
                text = { Text(text = stringResource(id = R.string.select)) }
            )
        },
        dismissButton = {
            CustomTextButton(
                onClick = onDismiss,
                text = { Text(text = stringResource(id = R.string.cancel)) }
            )
        }
    ) {
        CustomDatePicker(state = state)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomDatePicker(state: DatePickerState) {
    DatePicker(state = state)
}

@DevicePreview
@Composable
private fun CustomDialogSelectDatePrev() {
    AppTheme {
        CustomDialogSelectDate(onDismiss = {}, onSelected = {})
    }
}