package com.example.rickcameras.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.rickcameras.mvvm.cameras.CamerasState
import com.example.rickcameras.mvvm.cameras.CamerasViewModel
import com.example.rickcameras.mvvm.doors.DoorsState
import com.example.rickcameras.mvvm.doors.DoorsViewModel
import com.example.rickcameras.pages.CamerasScreen
import com.example.rickcameras.pages.DoorsScreen
import com.example.rickcameras.topbar.TabItem
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabContent(
    tabs:List<TabItem>,
    pagerState: PagerState,
    camerasViewModel: CamerasViewModel,
    doorsViewModel: DoorsViewModel,
    modifier: Modifier = Modifier
){
    HorizontalPager(
        state = pagerState,
        count = tabs.size,
        //modifier = modifier.padding(top = 8.dp)
    ) { page ->

        when(tabs[page]){
            is TabItem.Cameras ->{
                when(camerasViewModel.camerasData){
                    is CamerasState.Success -> {
                        tabs[page].screen = {
                            CamerasScreen(cameras = (camerasViewModel.camerasData as CamerasState.Success).cameras)
                        }
                        tabs[page].screen()
                    }
                    is CamerasState.Loading -> {

                    }
                    is CamerasState.Error -> {

                    }
                }
            }
            is TabItem.Doors -> {
                when(doorsViewModel.doorsData){
                    is DoorsState.Success -> {
                        tabs[page].screen = {
                            DoorsScreen(doors = (doorsViewModel.doorsData as DoorsState.Success).doors)
                        }
                        tabs[page].screen()
                    }
                    is DoorsState.Loading -> {

                    }
                    is DoorsState.Error -> {

                    }
                }
            }
        }

    }
}