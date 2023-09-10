package com.kakapo.trackmoney.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.kakapo.categories.navigation.categoriesScreen
import com.kakapo.overview.navigation.overviewScreen
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
        transactionScreen(openDrawer = openDrawer)
        categoriesScreen()
        overviewScreen()
    }
}