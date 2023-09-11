package com.kakapo.trackmoney.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.kakapo.categories.navigation.categoriesScreen
import com.kakapo.model.arguments.TransactionArguments
import com.kakapo.overview.navigation.overviewScreen
import com.kakapo.transaction.addTransaction.navigation.addTransactionScreen
import com.kakapo.transaction.addTransaction.navigation.navigateToAddTransactionScreen
import com.kakapo.transaction.calculator.navigation.calculatorScreen
import com.kakapo.transaction.calculator.navigation.navigateToCalculatorScreen
import com.kakapo.transaction.transaction.navigation.transactionScreen

@Composable
internal fun TrackMoneyNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    startDestination: String,
    openDrawer: () -> Unit
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        transactionScreen(
            openDrawer = openDrawer,
            openAddTransaction = navController::navigateToAddTransactionScreen
        )
        addTransactionScreen(onNavigateToCalculator = navController::navigateToCalculatorScreen)
        calculatorScreen(
            navigateToAddTransaction = { amount ->
                val backStack = navController.previousBackStackEntry
                val savedStateHandle = backStack?.savedStateHandle
                savedStateHandle?.set(TransactionArguments.EXPENSE, amount)
                navController.popBackStack()
            }
        )
        categoriesScreen()
        overviewScreen()
    }
}