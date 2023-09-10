package com.kakapo.designsystem.component.topAppBar

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.kakapo.common.type.FunUnit
import com.kakapo.designsystem.component.button.TopAppBarIcon

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
    Surface(shadowElevation = 2.dp) {
        TopAppBar(
            title = { Text(text = appBar.title) },
            navigationIcon = { TopAppBarIcon(icon = appBar.navigationIcon, onClick = onNavigate) },
            actions = {
                TopAppBarIcon(icon = appBar.firstActionIcon, onClick = onFirstAction)
                TopAppBarIcon(icon = appBar.secondActionIcon, onClick = onSecondAction)
            }
        )
    }
}