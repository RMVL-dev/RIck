package com.example.rickcameras.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.rickcameras.data.cameras.Cameras

@Composable
fun CamerasScreen(
    modifier:Modifier = Modifier,
    cameras: Cameras
){
    Column(modifier = modifier
        .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = cameras.success.toString())
    }
}