package com.example.rickcameras.di.cameras.classes

import com.example.rickcameras.data.cameras.Cameras
import com.example.rickcameras.di.cameras.interfaces.CamerasRepository
import com.example.rickcameras.network.CamerasService


class CamerasRepository(
    private val retrofit: CamerasService
): CamerasRepository {
    override suspend fun getCamerasData(): Cameras =
        retrofit.getCamerasData("")
}