package com.test.multitab.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.*
import com.test.multitab.ui.navigation.screens.MetaDataScreen
import com.test.multitab.ui.navigation.screens.UserListScreen
import kotlinx.coroutines.launch


@ExperimentalPagerApi
@Composable
fun TabLayout(
    modifier: Modifier
) {
    val pagerState = rememberPagerState(pageCount = 2)
    Column(modifier = modifier) {
        Tabs(pagerState = pagerState)
        TabsContent(pagerState = pagerState, modifier = modifier)
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
private fun TabsContent(pagerState: PagerState, modifier: Modifier) {
    HorizontalPager(state = pagerState) { page ->
        when (page) {
            0 -> UserListScreen(modifier = modifier)
            1 -> MetaDataScreen()
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
private fun Tabs(pagerState: PagerState) {
    val list = listOf(
        "Home" to Icons.Default.Home,
        "your Updates" to Icons.Default.Info
    )

    val scope = rememberCoroutineScope()

    TabRow(
        selectedTabIndex = pagerState.currentPage,
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = Color.White,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                Modifier.pagerTabIndicatorOffset(pagerState, tabPositions),
                height = 2.dp,
                color = Color.White
            )
        }
    ) {
        list.forEachIndexed { index, _ ->
            Tab(
                icon = {
                    Icon(imageVector = list[index].second, contentDescription = null)
                },
                text = {
                    Text(
                        list[index].first,
                        color = if (pagerState.currentPage == index) Color.White else Color.LightGray
                    )
                },
                selected = pagerState.currentPage == index,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                }
            )
        }
    }
}