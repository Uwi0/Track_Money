package com.kakapo.trackmoney.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.kakapo.trackmoney.navigation.MainMenuNavigation
import com.kakapo.trackmoney.navigation.TrackMoneyNavHost
import kotlinx.coroutines.launch

@Composable
internal fun TrackMoneyApp(
    startDestination: String,
    trackMoneyAppState: TrackMoneyAppState = rememberTrackingMoneyAppState()
) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet() {
                MainMenuNavigation.entries.forEach { menu ->
                    DrawerMenuItem(
                        menu = menu, onClick = {
                            trackMoneyAppState.navigateToCurrentMainMenu(menu)
                            scope.launch { drawerState.close() }
                        }
                    )
                }
            }
        }
    ) {
        Surface(modifier = Modifier.fillMaxSize()) {
            TrackMoneyNavHost(
                navController = trackMoneyAppState.navController,
                startDestination = startDestination
            )
        }
    }
}

@Composable
private fun DrawerMenuItem(
    menu: MainMenuNavigation,
    onClick: (MainMenuNavigation) -> Unit
) {
    val textItem = stringResource(id = menu.title)
    NavigationDrawerItem(
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
        icon = {
            Icon(imageVector = menu.icon, contentDescription = textItem)
        },
        label = { Text(text = textItem) },
        selected = false,
        onClick = { onClick.invoke(menu) }
    )
}