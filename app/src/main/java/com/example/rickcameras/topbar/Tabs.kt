package com.example.rickcameras.topbar

import androidx.compose.foundation.background
import androidx.compose.material3.LeadingIconTab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
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
        },
        backgroundColor = Color.White
    ) { tabs.forEachIndexed { index, tabItem ->
        LeadingIconTab(
            selected = pagerState.currentPage == index,
            onClick = {
                scope.launch {
                    pagerState.animateScrollToPage(index)
                }
                      },
            text = {
                Text(
                    text = tabItem.title,
                    fontSize = 25.sp
                )
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