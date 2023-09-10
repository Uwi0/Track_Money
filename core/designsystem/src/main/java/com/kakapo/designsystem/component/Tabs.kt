package com.kakapo.designsystem.component

//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.padding
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.ProvideTextStyle
//import androidx.compose.material3.Tab
//import androidx.compose.material3.TabRow
//import androidx.compose.material3.TabRowDefaults.Indicator
//import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.rememberCoroutineScope
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.vector.ImageVector
//import androidx.compose.ui.res.stringResource
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.unit.dp
//import com.google.accompanist.pager.ExperimentalPagerApi
//import com.google.accompanist.pager.HorizontalPager
//import com.google.accompanist.pager.PagerState
//import kotlinx.coroutines.launch
//data class TabsTitle(
//    val title: Int,
//    val icon: ImageVector? = null
//)
//
//@OptIn(ExperimentalPagerApi::class, ExperimentalFoundationApi::class)
//@Composable
//fun TabsRowScreen(
//    modifier: Modifier = Modifier,
//    pagerState: PagerState,
//    tabCount: Int,
//    tabsTitle: List<TabsTitle>,
//    content: @Composable (Int) -> Unit
//) {
//
//    val scope = rememberCoroutineScope()
//    TabRow(
//        modifier = modifier,
//        selectedTabIndex = pagerState.currentPage,
//        containerColor = MaterialTheme.colorScheme.surface,
//        contentColor = MaterialTheme.colorScheme.primary,
//        indicator = { tabPositions ->
//            Indicator(
//                modifier = Modifier.tabIndicatorOffset(tabPositions[pagerState.currentPage]),
//                height = 2.dp,
//                color = MaterialTheme.colorScheme.primary
//            )
//        },
//        tabs = {
//            tabsTitle.forEachIndexed { index, tabs ->
//                val selected = pagerState.currentPage == index
//                val textColor = if (selected) MaterialTheme.colorScheme.primary
//                else MaterialTheme.colorScheme.onSurfaceVariant
//                Tab(
//                    text = {
//                        Text(
//                            text = stringResource(id = tabs.title),
//                            style = MaterialTheme.typography.labelLarge,
//                            color = textColor
//                        )
//                    },
//                    selected = selected,
//                    onClick = {
//                        scope.launch {
//                            pagerState.animateScrollToPage(index)
//                        }
//                    }
//                )
//            }
//        }
//    )
//    HorizontalPager(
//        state = pagerState,
//        count = tabCount
//    ) { page ->
//        content(page)
//    }
//}
//
//@Composable
//fun CustomTab(
//    selected: Boolean,
//    onClick: () -> Unit,
//    modifier: Modifier = Modifier,
//    enabled: Boolean = true,
//    text: @Composable () -> Unit,
//) {
//    Tab(
//        selected = selected,
//        onClick = onClick,
//        modifier = modifier,
//        enabled = enabled,
//        text = {
//            val textColor = if (selected) MaterialTheme.colorScheme.primary
//            else MaterialTheme.colorScheme.onSurfaceVariant
//            val style = MaterialTheme.typography.labelLarge.copy(
//                textAlign = TextAlign.Center,
//                color = textColor
//            )
//            ProvideTextStyle(
//                value = style,
//                content = {
//                    Box(modifier = Modifier.padding(top = JarivisTabDefaults.TabTopPadding)) {
//                        text()
//                    }
//                },
//            )
//        },
//    )
//}
//
//@Composable
//fun CustomTabRow(
//    selectedTabIndex: Int,
//    modifier: Modifier = Modifier,
//    tabs: @Composable () -> Unit,
//) {
//    TabRow(
//        selectedTabIndex = selectedTabIndex,
//        modifier = modifier,
//        containerColor = MaterialTheme.colorScheme.surface,
//        contentColor = MaterialTheme.colorScheme.primary,
//        indicator = { tabPositions ->
//            Indicator(
//                modifier = Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex]),
//                height = 2.dp,
//                color = MaterialTheme.colorScheme.primary
//            )
//        },
//        tabs = tabs,
//    )
//}
//
//object JarivisTabDefaults {
//    val TabTopPadding = 7.dp
//}