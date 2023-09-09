package com.kakapo.categories.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.kakapo.categories.CategoriesRoute

const val CATEGORIES_ROUTE = "categories"

fun NavController.navigateToCategories(navOptions: NavOptions? = null) {
    this.navigate(CATEGORIES_ROUTE, navOptions)
}

fun NavGraphBuilder.categoriesScreen() {
    composable(CATEGORIES_ROUTE) {
        CategoriesRoute()
    }
}