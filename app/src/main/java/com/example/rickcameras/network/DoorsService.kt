package com.example.rickcameras.network

import com.example.rickcameras.data.doors.Doors
import retrofit2.http.GET
import retrofit2.http.Url

interface DoorsService {
    @GET
    suspend fun getDoorsData(@Url url:String):Doors
}