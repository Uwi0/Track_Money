package com.kakapo.transaction.transaction

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Event
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.kakapo.common.type.FunUnit
import com.kakapo.designsystem.component.topAppBar.ContentActionTopAppBar
import com.kakapo.designsystem.component.topAppBar.NavigationTopAppBarWithTwoAction
import com.kakapo.transaction.R

@Composable
internal fun TransactionRoute(openDrawer: () -> Unit, openAddTransaction: () -> Unit) {
    TransactionScreen(openDrawer, openAddTransaction)
}

@Composable
internal fun TransactionScreen(openDrawer: () -> Unit, openAddTransaction: () -> Unit) {
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
                onClick = openAddTransaction,
                expanded = false
            )
        },
        content = {
            Column(modifier = Modifier.padding(it)) {

            }
        }
    )
}

@Composable
private fun TransactionToAppbar(
    openDrawer: FunUnit,
    onSearch: FunUnit,
    onSearchByDate: FunUnit
) {
    val topAppbar = ContentActionTopAppBar(
        navigationIcon = Icons.Default.Menu,
        title = stringResource(id = R.string.title_transaction),
        firstActionIcon = Icons.Default.Search,
        secondActionIcon = Icons.Default.Event
    )
    NavigationTopAppBarWithTwoAction(
        appBar = topAppbar,
        onNavigate = openDrawer,
        onFirstAction = onSearch,
        onSecondAction = onSearchByDate
    )
}
