package com.kakapo.trackmoney.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.kakapo.categories.navigation.navigateToCategories
import com.kakapo.overview.navigation.navigateToOverviewScreen
import com.kakapo.trackmoney.navigation.MainMenuNavigation
import com.kakapo.transaction.transaction.navigation.navigateToTransaction
import com.kakapo.ui.TrackDisposableJank

@Composable
internal fun rememberTrackingMoneyAppState(
    navController: NavHostController = rememberNavController()
): TrackMoneyAppState {
    NavigationTrackingSideEffect(navController = navController)
    return remember {
        TrackMoneyAppState(navController)
    }
}

@Stable
internal class TrackMoneyAppState(
    val navController: NavHostController
) {

    val currentDestination: NavDestination?
        @Composable get() = navController.currentBackStackEntryAsState().value?.destination

    fun navigateToCurrentMainMenu(menu: MainMenuNavigation) {
        when (menu) {
            MainMenuNavigation.Transaction -> navController.navigateToTransaction()
            MainMenuNavigation.Categories -> navController.navigateToCategories()
            MainMenuNavigation.OverView -> navController.navigateToOverviewScreen()
        }
    }
}

@Composable
private fun NavigationTrackingSideEffect(navController: NavController) {
    TrackDisposableJank(navController) { metricsHolder ->
        val listener = NavController.OnDestinationChangedListener { _, destination, _ ->
            metricsHolder.state?.putState("Navigation", destination.route.toString())
        }

        navController.addOnDestinationChangedListener(listener)

        onDispose {
            navController.removeOnDestinationChangedListener(listener)
        }
    }
}