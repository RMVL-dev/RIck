package com.example.rickcameras.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.rickcameras.mvvm.cameras.CamerasViewModel
import com.example.rickcameras.mvvm.doors.DoorsViewModel
import com.example.rickcameras.provider.AppViewModelProvider
import com.example.rickcameras.topbar.TabItem
import com.example.rickcameras.topbar.Tabs
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState

enum class NavigationGraph(title:String) {
    Cameras(title = "Cameras"),
    Doors(title = "Doors")
}


@OptIn(ExperimentalMaterial3Api::class, ExperimentalPagerApi::class)
@Composable
fun CamerasApp(
    modifier: Modifier = Modifier,
    //navController: NavHostController = rememberNavController(),
    camerasViewModel: CamerasViewModel = viewModel(
        factory = AppViewModelProvider.Factory
    ),
    doorsViewModel: DoorsViewModel = viewModel(
        factory = AppViewModelProvider.Factory
    )
){
    val tabs = listOf(
        TabItem.Cameras,
        TabItem.Doors
    )
    val pagerState = rememberPagerState()
    Scaffold(
        topBar = {}
    ) {paddingValues ->
        Column(
            modifier = modifier
                .padding(paddingValues = paddingValues)
        ) {
            Tabs(pagerState = pagerState, tabs = tabs)
            TabContent(
                tabs = tabs,
                pagerState = pagerState,
                camerasViewModel = camerasViewModel,
                doorsViewModel = doorsViewModel
            )
        }
    }
}


/*
NavHost(
            navController = navController,
            startDestination = NavigationGraph.Cameras.name,
            modifier = modifier.padding(paddingValues = paddingValues)
        ){
            composable(route = NavigationGraph.Cameras.name){
                when(camerasViewModel.camerasData){
                    is CamerasState.Success -> {

                    }
                    is CamerasState.Loading -> {

                    }
                    is CamerasState.Error -> {

                    }
                }
            }
            composable(route = NavigationGraph.Doors.name){
                when(doorsViewModel.doorsData){
                    is DoorsState.Success -> {

                    }
                    is DoorsState.Loading -> {

                    }
                    is DoorsState.Error -> {

                    }
                }
            }
        }
 */