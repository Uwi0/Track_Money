package com.kakapo.transaction.addTransaction.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.kakapo.transaction.addTransaction.AddTransactionRoute

const val ADD_TRANSACTION_ROUTE = "add_transaction_route"

fun NavController.navigateToAddTransactionScreen(navOptions: NavOptions? = null) {
    this.navigate(ADD_TRANSACTION_ROUTE, navOptions)
}

fun NavGraphBuilder.addTransactionScreen() {
    composable(ADD_TRANSACTION_ROUTE) {
        AddTransactionRoute()
    }
}