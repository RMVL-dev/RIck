package com.example.rickcameras.mvvm.cameras

import com.example.rickcameras.data.cameras.Cameras

sealed interface CamerasState{

    data class Success(val cameras:Cameras):CamerasState

    object Loading:CamerasState

    object Error:CamerasState

}