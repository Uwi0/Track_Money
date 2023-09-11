package com.kakapo.designsystem.component.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import com.kakapo.designsystem.component.ThemePreviews
import com.kakapo.designsystem.theme.AppTheme

@Composable
fun CustomButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    colors: ButtonColors = ButtonDefaults.buttonColors(
        containerColor = MaterialTheme.colorScheme.primary,
    ),
    shape: Shape = MaterialTheme.shapes.medium,
    content: @Composable RowScope.() -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        colors = colors,
        contentPadding = contentPadding,
        content = content,
        shape = shape
    )
}

@Composable
fun CustomButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    colors: ButtonColors = ButtonDefaults.buttonColors(),
    shape: Shape = MaterialTheme.shapes.medium,
    text: @Composable () -> Unit,
    leadingIcon: @Composable (() -> Unit)? = null,
) {
    CustomButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        contentPadding = if (leadingIcon != null) {
            ButtonDefaults.ButtonWithIconContentPadding
        } else {
            ButtonDefaults.ContentPadding
        },
        colors = colors,
        shape = shape
    ) {
        JarivisButtonContent(
            text = text,
            leadingIcon = leadingIcon,
        )
    }
}

@Composable
fun CustomPrimaryColorButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    text: @Composable () -> Unit,
    leadingIcon: @Composable() (() -> Unit)? = null,
) {
    CustomButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.primary
        )
    ) {
        JarivisButtonContent(
            text = text,
            leadingIcon = leadingIcon,
        )
    }
}

@Composable
fun OutlinedButtonError(
    onclick: () -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    content: @Composable RowScope.() -> Unit
) {
    OutlinedButton(
        onClick = onclick,
        modifier = modifier,
        contentPadding = contentPadding,
        border = BorderStroke(
            CustomButtonDefaults.OutlinedButtonBorderWidth,
            color = MaterialTheme.colorScheme.error
        ),
        shape = RoundedCornerShape(8.dp),
        content = content
    )
}

@Composable
fun CustomOutlinedButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    shape: Shape = MaterialTheme.shapes.medium,
    content: @Composable RowScope.() -> Unit,
) {
    OutlinedButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        border = BorderStroke(
            width = CustomButtonDefaults.OutlinedButtonBorderWidth,
            color = if (enabled) {
                MaterialTheme.colorScheme.primary
            } else {
                MaterialTheme.colorScheme.onSurface.copy(
                    alpha = CustomButtonDefaults.DisabledOutlinedButtonBorderAlpha,
                )
            },
        ),
        contentPadding = contentPadding,
        content = content,
        shape = shape
    )
}

@Composable
fun CustomOutlinedButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    text: @Composable () -> Unit,
    leadingIcon: @Composable (() -> Unit)? = null,
) {
    CustomOutlinedButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        contentPadding = if (leadingIcon != null) {
            ButtonDefaults.ButtonWithIconContentPadding
        } else {
            ButtonDefaults.ContentPadding
        },
    ) {
        JarivisButtonContent(
            text = text,
            leadingIcon = leadingIcon,
        )
    }
}

@Composable
fun CustomTextButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = MaterialTheme.shapes.medium,
    content: @Composable RowScope.() -> Unit
) {
    TextButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        shape = shape,
        content = content
    )
}

@Composable
fun CustomTextButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    text: @Composable () -> Unit,
    leadingIcon: @Composable (() -> Unit)? = null,
) {
    CustomTextButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
    ) {
        JarivisButtonContent(
            text = text,
            leadingIcon = leadingIcon,
        )
    }
}

@Composable
private fun JarivisButtonContent(
    text: @Composable () -> Unit,
    leadingIcon: @Composable (() -> Unit)? = null,
) {
    if (leadingIcon != null) {
        Box(Modifier.sizeIn(maxHeight = ButtonDefaults.IconSize)) {
            leadingIcon()
        }
    }
    Box(
        Modifier
            .padding(
                start = if (leadingIcon != null) {
                    ButtonDefaults.IconSpacing
                } else {
                    0.dp
                },
            ),
    ) {
        text()
    }
}


object CustomButtonDefaults {
    const val DisabledOutlinedButtonBorderAlpha = 0.12f
    val OutlinedButtonBorderWidth = 1.dp
}

@ThemePreviews
@Composable
fun CustomButtonPreview() {
    AppTheme {
        CustomButton(onClick = {}, text = { Text("Test button") })
    }
}

@ThemePreviews
@Composable
fun CustomOutlinedButtonPreview() {
    AppTheme() {
        CustomOutlinedButton(onClick = {}, text = { Text("Test button") })
    }
}

@ThemePreviews
@Composable
fun CustomButtonPreview2() {
    AppTheme {
        CustomButton(onClick = {}, text = { Text("Test button") })
    }
}

@ThemePreviews
@Composable
fun CustomButtonLeadingIconPreview() {
    AppTheme {
        CustomButton(
            onClick = {},
            text = { Text("Test button") },
            leadingIcon = { Icon(imageVector = Icons.Default.Add, contentDescription = null) },
        )
    }
}

