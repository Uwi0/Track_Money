package com.kakapo.transaction.transaction

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Event
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.kakapo.transaction.R

@Composable
internal fun TransactionRoute(openDrawer: () -> Unit) {
    TransactionScreen(openDrawer)
}

@Composable
internal fun TransactionScreen(openDrawer: () -> Unit) {
    Scaffold(
        topBar = {
            TransactionToAppbar(
                openDrawer = openDrawer,
                onSearch = {},
                onSearchByDate = {}
            )
        },
        floatingActionButton = {
            val buttonText = stringResource(id = R.string.add_transaction)
            ExtendedFloatingActionButton(
                text = { Text(text = buttonText) },
                icon = { Icon(imageVector = Icons.Default.Add, contentDescription = buttonText) },
                onClick = { /*TODO*/ },
                expanded = false
            )
        },
        content = {
            Column(modifier = Modifier.padding(it)) {

            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TransactionToAppbar(
    openDrawer: () -> Unit,
    onSearch: () -> Unit,
    onSearchByDate: () -> Unit
) {
    Surface(shadowElevation = 2.dp) {
        TopAppBar(
            title = { Text(text = stringResource(id = R.string.title_transaction)) },
            navigationIcon = { TopAppBarIcon(icon = Icons.Default.Menu, onClick = openDrawer) },
            actions = {
                TopAppBarIcon(icon = Icons.Default.Search, onClick = onSearch)
                TopAppBarIcon(icon = Icons.Default.Event, onClick = onSearchByDate)
            }
        )
    }
}

@Composable
private fun TopAppBarIcon(icon: ImageVector, onClick: () -> Unit) {
    IconButton(onClick = onClick) {
        Icon(imageVector = icon, contentDescription = "")
    }
}