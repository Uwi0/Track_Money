package com.kakapo.designsystem.component.icon

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.kakapo.designsystem.component.ThemePreviews
import com.kakapo.designsystem.theme.AppTheme

@Composable
fun InitialIcon(
    name: String,
    color: Color,
    size: Dp = 48.dp
) {
    val initials = name.split(" ")
        .take(2)
        .mapNotNull { it.firstOrNull()?.toString() }
        .joinToString("")

    Surface(
        modifier = Modifier.size(size),
        shape = CircleShape,
        color = color
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Text(modifier = Modifier.align(Alignment.Center), text = initials)
        }
    }
}

@ThemePreviews
@Composable
private fun InitialIconPrev(){
    AppTheme {
        InitialIcon(name = "Home", color = Color(0xFF6750A4))
    }
}