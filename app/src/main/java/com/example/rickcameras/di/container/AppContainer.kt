package com.example.rickcameras.di.container

import com.example.rickcameras.di.repositories.interfaces.CamerasRepository
import com.example.rickcameras.di.repositories.interfaces.DoorsRepository

interface AppContainer {
    val camerasRepository: CamerasRepository
    val doorsRepository: DoorsRepository
}