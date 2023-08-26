package com.example.rickcameras.di.repositories.classes

import com.example.rickcameras.data.cameras.Cameras
import com.example.rickcameras.di.repositories.interfaces.CamerasRepository
import com.example.rickcameras.network.CamerasService


class CamerasRepository(
    private val retrofit: CamerasService
): CamerasRepository {
    override suspend fun getCamerasData(): Cameras =
        retrofit.getCamerasData("")
}