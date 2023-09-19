package com.kakapo.pickCategory

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.kakapo.categories.R
import com.kakapo.designsystem.animation.slidingContentAnimation
import com.kakapo.designsystem.component.tabs.CustomTab
import com.kakapo.designsystem.component.tabs.CustomTabRow
import com.kakapo.designsystem.component.topAppBar.NavigationUpTopAppbar

const val TAB_LABEL = "AnimateCategoriesTab"

@Composable
internal fun PickCategoryRoute() {
    PickCategoryScreen()
}

@Composable
internal fun PickCategoryScreen() {
    Scaffold(
        topBar = {
            NavigationUpTopAppbar(
                title = stringResource(id = R.string.title_pick_category),
                onNavigate = {}
            )
        },
        content = {
            Column(modifier = Modifier.padding(it)) {
                var currentTab by remember { mutableStateOf(TypeCategories.Expense) }
                CustomTabRow(selectedTabIndex = currentTab.ordinal) {
                    for (entry in TypeCategories.entries) {
                        val title = stringResource(id = entry.title)
                        val selected = entry == currentTab
                        CustomTab(selected = selected, onClick = { currentTab = entry }) {
                            Text(text = title)
                        }
                    }
                }
                AnimatedContent(
                    targetState = currentTab.ordinal,
                    label = TAB_LABEL,
                    transitionSpec = { slidingContentAnimation() }
                ) {tab ->
                    when(tab){
                        TypeCategories.Expense.ordinal -> CategoriesList(title = "Expense")
                        TypeCategories.Income.ordinal -> CategoriesList(title = "Income")
                    }
                }
            }
        }
    )
}

@Composable
private fun CategoriesList(title: String){
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "$title not implemented yet")
    }
}

enum class TypeCategories(val title: Int) {
    Expense(R.string.expense),
    Income(R.string.income)
}