package com.kakapo.overview.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.kakapo.overview.OverviewRoute

const val OVERVIEW_ROUTE = "overview_route"

fun NavController.navigateToOverviewScreen(navOptions: NavOptions? = null) {
    this.navigate(OVERVIEW_ROUTE, navOptions)
}

fun NavGraphBuilder.overviewScreen() {
    composable(OVERVIEW_ROUTE) {
        OverviewRoute()
    }
}