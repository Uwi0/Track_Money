package com.kakapo.pickCategory

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.kakapo.categories.R
import com.kakapo.designsystem.component.topAppBar.NavigationUpTopAppbar

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
        content = { padding ->
            Box(modifier = Modifier.padding(padding)) {

            }
        }
    )
}