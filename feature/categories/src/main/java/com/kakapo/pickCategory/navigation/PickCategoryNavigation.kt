package com.kakapo.pickCategory.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.kakapo.pickCategory.PickCategoryRoute

const val PICK_CATEGORY_SCREEN = "pick_category_screen"

fun NavController.navigateToPickCategoryScreen(navOptions: NavOptions? = null) {
    this.navigate(PICK_CATEGORY_SCREEN, navOptions)
}

fun NavGraphBuilder.pickCategoryScreen() {
    composable(PICK_CATEGORY_SCREEN) {
        PickCategoryRoute()
    }
}