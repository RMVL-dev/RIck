package com.example.rickcameras.di.doors.classes

import com.example.rickcameras.data.doors.Doors
import com.example.rickcameras.di.doors.interfaces.DoorsRepository
import com.example.rickcameras.network.DoorsService

class DoorsRepository(
    private val retrofit:DoorsService
):DoorsRepository {
    override suspend fun getDoorsData(): Doors =
        retrofit.getDoorsData("")
}