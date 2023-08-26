package com.example.rickcameras.di.repositories.interfaces

import com.example.rickcameras.data.doors.Doors

interface DoorsRepository {
    suspend fun getDoorsData():Doors
}