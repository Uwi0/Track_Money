package com.kakapo.transaction.calculator.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.kakapo.transaction.calculator.CalculatorRoute

const val CALCULATOR_SCREEN = "calculator_screen"

fun NavController.navigateToCalculatorScreen(navOptions: NavOptions? = null) {
    this.navigate(CALCULATOR_SCREEN)
}

fun NavGraphBuilder.calculatorScreen(navigateToAddTransaction: (String) -> Unit) {
    composable(CALCULATOR_SCREEN) {
        CalculatorRoute(navigateToAddTransaction = navigateToAddTransaction)
    }
}