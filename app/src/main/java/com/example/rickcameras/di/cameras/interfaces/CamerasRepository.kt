package com.example.rickcameras.di.cameras.interfaces

import com.example.rickcameras.data.cameras.Cameras

interface CamerasRepository {
    suspend fun getCamerasData():Cameras
}