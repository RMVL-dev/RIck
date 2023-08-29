package com.example.rickcameras.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.rickcameras.R
import com.example.rickcameras.data.doors.Doors
import com.example.rickcameras.data.doors.utils.DoorData


@Composable
fun DoorsScreen(
    modifier: Modifier = Modifier,
    doors: Doors
){

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(8.dp)
    ){
        if (!doors.data.isNullOrEmpty()) items(
            items = doors.data
        ){ door ->
            if (door.snapshot.isNullOrEmpty()) {
                DoorCardWithoutSnapshot(door = door)
            }else{
                DoorCardWithSnapshot(door = door)
            }
        }
    }



    //Column(modifier = modifier
    //    .fillMaxWidth(),
    //    horizontalAlignment = Alignment.Start
    //) {
    //    Text(text = doors.success.toString())
    //}
}



@Composable
fun DoorCardWithSnapshot(
    modifier: Modifier = Modifier,
    door: DoorData
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
                model = door.snapshot,
                contentDescription = door.name,
                modifier = modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            door.name?.let {
                Text(
                    modifier = modifier.padding(8.dp),
                    text = it,
                    fontSize = 20.sp
                )
            }
        }
    }

}

@Composable
fun DoorCardWithoutSnapshot(
    modifier: Modifier = Modifier,
    door:DoorData
){
    Card(modifier = modifier
        .fillMaxWidth()
        .height(100.dp)
        .padding(bottom = 16.dp),
    ) {
        Row(
            modifier = modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            door.name?.let {
                Text(
                    text = it,
                    modifier = modifier
                        .weight(1f),
                    fontSize = 20.sp,
                    textAlign = TextAlign.Start
                )
            }
            Image(
                painter = painterResource(id = R.drawable.outline_lock_24),
                contentDescription = "img",
                modifier = modifier
                    .weight(1f),
                alignment = Alignment.CenterEnd
            )
        }
    }
}