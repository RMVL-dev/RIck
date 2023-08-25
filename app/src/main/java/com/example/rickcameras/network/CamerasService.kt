package com.example.rickcameras.network

import com.example.rickcameras.data.cameras.Cameras
import retrofit2.http.GET
import retrofit2.http.Url

interface CamerasService {
    @GET
    suspend fun getCamerasData(@Url url: String):Cameras
}