package com.kakapo.designsystem.component.textfield

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.kakapo.common.type.FunUnit

@Composable
fun CustomTextFieldWithIcon(
    query: String,
    placeholder: String,
    icon: ImageVector,
    onQueryChange: (String) -> Unit
) {
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        value = query,
        onValueChange = onQueryChange,
        placeholder = {
            Text(text = placeholder)
        },
        leadingIcon = {
            Icon(imageVector = icon, contentDescription = placeholder)
        },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            disabledContainerColor = Color.Transparent,
        ),
        maxLines = 1,
        singleLine = true
    )
}


@Composable
fun ClickAbleCustomTextFieldWithIcon(
    query: String,
    placeholder: String,
    icon: ImageVector,
    onClick: FunUnit
) {
    val interactionSource = remember { MutableInteractionSource() }
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        readOnly = true,
        value = query,
        onValueChange = {},
        placeholder = {
            Text(text = placeholder)
        },
        leadingIcon = {
            Icon(imageVector = icon, contentDescription = placeholder)
        },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            disabledContainerColor = Color.Transparent,
        ),
        maxLines = 1,
        singleLine = true,
        interactionSource = interactionSource.also { interaction ->
            LaunchedEffect(key1 = interaction) {
                interaction.interactions.collect {
                    if (it is PressInteraction.Release) {
                        onClick.invoke()
                    }
                }
            }
        }
    )
}