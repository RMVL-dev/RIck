package com.example.rickcameras.di.repositories.interfaces

import com.example.rickcameras.data.cameras.Cameras

interface CamerasRepository {
    suspend fun getCamerasData():Cameras
}