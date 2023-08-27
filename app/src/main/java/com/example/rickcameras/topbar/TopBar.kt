package com.example.rickcameras.topbar

import androidx.compose.material3.LeadingIconTab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.pagerTabIndicatorOffset
import kotlinx.coroutines.launch


@ExperimentalPagerApi
@Composable
fun Tabs(
    modifier:Modifier = Modifier,
    pagerState: PagerState,
    tabs:List<TabItem>
){
    val scope = rememberCoroutineScope()
    androidx.compose.material.TabRow(
        selectedTabIndex = pagerState.currentPage,
        indicator = {tabPositions ->
            TabRowDefaults.Indicator(
                modifier = modifier.pagerTabIndicatorOffset(
                pagerState = pagerState,
                tabPositions = tabPositions
                )
            )
        }
    ) { tabs.forEachIndexed { index, tabItem ->
        LeadingIconTab(
            selected = pagerState.currentPage == index,
            onClick = {
                scope.launch {
                    pagerState.animateScrollToPage(index)
                }
                      },
            text = {
                Text(text = tabItem.title)
                   },
            icon = {}
        )
    } }
}



/*
@OptIn(ExperimentalPagerApi::class)
@Preview
@Composable
fun TestTopBar(){
    Tabs(
        pagerState = rememberPagerState(),
        tabs = tabs
    )
}*/