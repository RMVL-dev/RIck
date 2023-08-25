package com.example.rickcameras

import android.os.Bundle
import android.text.Editable.Factory
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.rickcameras.data.cameras.Cameras
import com.example.rickcameras.mvvm.cameras.CamerasState
import com.example.rickcameras.mvvm.cameras.CamerasViewModel
import com.example.rickcameras.provider.AppViewModelProvider
import com.example.rickcameras.ui.theme.RIckCamerasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RIckCamerasTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Test()
                }
            }
        }
    }
}

@Composable
fun Test(
    camerasViewModel:CamerasViewModel = viewModel(
        factory = AppViewModelProvider.Factory
    )
){
    when(camerasViewModel.camerasData){
        is CamerasState.Success -> {
            DataTest(cameras = (camerasViewModel.camerasData as CamerasState.Success).cameras)
        }
        is CamerasState.Error -> {
            Box(modifier = Modifier
                .size(64.dp)
                .background(color = Color.Red)) {

            }
        }
        is CamerasState.Loading -> {
            Box(modifier = Modifier
                .size(64.dp)
                .background(color = Color.Yellow)) {
            }
        }
    }
    
}

@Composable
fun DataTest (
    cameras:Cameras
){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White)){
        Column(modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)) {

            Text(
                text = cameras.success.toString(),
                fontSize = 25.sp
            )
        }
    }
}