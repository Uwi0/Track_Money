package com.kakapo.pickCategory

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.kakapo.categories.R
import com.kakapo.designsystem.animation.slidingContentAnimation
import com.kakapo.designsystem.component.icon.InitialIcon
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
                CategoriesTabs(currentTab = currentTab, onClick = { currentTab = it })
                CategoriesScreen(currentTab = currentTab)
            }
        }
    )
}

@Composable
private fun CategoriesTabs(currentTab: TypeCategories, onClick: (TypeCategories) -> Unit) {
    CustomTabRow(selectedTabIndex = currentTab.ordinal) {
        for (entry in TypeCategories.entries) {
            val title = stringResource(id = entry.title)
            val selected = entry == currentTab
            CustomTab(
                selected = selected,
                onClick = { onClick.invoke(entry) },
                text = { Text(text = title) }
            )
        }
    }
}


@Composable
private fun CategoriesScreen(currentTab: TypeCategories) {
    AnimatedContent(
        targetState = currentTab.ordinal,
        label = TAB_LABEL,
        transitionSpec = { slidingContentAnimation() }
    ) { tab ->
        when (tab) {
            TypeCategories.Expense.ordinal -> CategoriesList(title = "Expense")
            TypeCategories.Income.ordinal -> CategoriesList(title = "Income")
        }
    }
}


@Composable
private fun CategoriesList(title: String) {
    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(10) {
            CardCategories(title = "Categories")
        }
    }
}

@Composable
private fun CardCategories(title: String) {
    ListItem(
        shadowElevation = 2.dp,
        headlineContent = { Text(text = title) },
        leadingContent = { InitialIcon(name = title, color = Color(0xFF6750A4)) }
    )
}

enum class TypeCategories(val title: Int) {
    Expense(R.string.expense),
    Income(R.string.income)
}