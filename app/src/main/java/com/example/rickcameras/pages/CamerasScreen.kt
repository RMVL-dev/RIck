package com.example.rickcameras.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.rickcameras.data.cameras.Cameras
import com.example.rickcameras.data.cameras.utils.Camera

@Composable
fun CamerasScreen(
    modifier:Modifier = Modifier,
    cameras: Cameras
){
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 8.dp)
    ){
        if (!cameras.data.cameras.isNullOrEmpty()) items(
            items = cameras.data.cameras
        ) {camera->
            CameraCard(camera = camera)
        }
    }
}



@Composable
fun CameraCard(
    modifier: Modifier = Modifier,
    camera: Camera
){
    Card(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(bottom = 16.dp),
        shape = MaterialTheme.shapes.medium
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
        ) {
            AsyncImage(
                model = camera.snapshot,
                contentDescription = camera.name,
                modifier = modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            camera.name?.let {
                Text(
                    modifier = modifier.padding(8.dp),
                    text = it,
                    fontSize = 20.sp
                )
            }
        }
    }

}