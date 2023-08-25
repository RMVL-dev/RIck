package com.example.rickcameras.di.doors.interfaces

import com.example.rickcameras.data.doors.Doors

interface DoorsRepository {
    suspend fun getDoorsData():Doors
}