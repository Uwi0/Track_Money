package com.kakapo.trackmoney.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector
import com.kakapo.categories.R as categoriesR
import com.kakapo.overview.R as overviewR
import com.kakapo.transaction.R as transactionR

enum class MainMenuNavigation(val icon: ImageVector, val title: Int) {
    Transaction(Icons.Default.ShoppingCart, transactionR.string.title_transaction),
    Categories(Icons.Default.Category, categoriesR.string.title_categories),
    OverView(Icons.Default.BarChart, overviewR.string.title_overview)
}