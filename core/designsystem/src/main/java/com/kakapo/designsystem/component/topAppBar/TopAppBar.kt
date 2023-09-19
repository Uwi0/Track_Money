package com.kakapo.designsystem.component.topAppBar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.kakapo.common.type.FunUnit
import com.kakapo.designsystem.component.button.AppBarIcon

data class ContentActionTopAppBar(
    val navigationIcon: ImageVector,
    val title: String,
    val firstActionIcon: ImageVector,
    val secondActionIcon: ImageVector
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationTopAppBarWithTwoAction(
    appBar: ContentActionTopAppBar,
    onNavigate: FunUnit,
    onFirstAction: FunUnit,
    onSecondAction: FunUnit
) {
    SurfaceTopAppBar {
        TopAppBar(
            title = { Text(text = appBar.title) },
            navigationIcon = { AppBarIcon(icon = appBar.navigationIcon, onClick = onNavigate) },
            actions = {
                AppBarIcon(icon = appBar.firstActionIcon, onClick = onFirstAction)
                AppBarIcon(icon = appBar.secondActionIcon, onClick = onSecondAction)
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationUpTopAppbar(title: String, onNavigate: FunUnit) {
    SurfaceTopAppBar {
        TopAppBar(
            title = { Text(text = title) },
            navigationIcon = { AppBarIcon(icon = Icons.Default.ArrowBack, onClick = onNavigate) }
        )
    }
}

@Composable
private fun SurfaceTopAppBar(content: @Composable FunUnit) {
    Surface(shadowElevation = 2.dp) {
        content.invoke()
    }
}