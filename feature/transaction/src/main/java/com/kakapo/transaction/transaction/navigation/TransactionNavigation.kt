package com.kakapo.transaction.transaction.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.kakapo.transaction.transaction.TransactionRoute

const val TRANSACTION_ROUTE = "transaction_route"

fun NavController.navigateToTransaction(navOptions: NavOptions? = null) {
    this.navigate(TRANSACTION_ROUTE, navOptions)
}

fun NavGraphBuilder.transactionScreen(
    openDrawer: () -> Unit,
    openAddTransaction: () -> Unit
) {
    composable(TRANSACTION_ROUTE) {
        TransactionRoute(openDrawer, openAddTransaction)
    }
}