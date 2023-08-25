package com.example.rickcameras

import android.app.Application
import com.example.rickcameras.di.cameras.classes.CamerasContainer
import com.example.rickcameras.di.cameras.interfaces.CamerasAppContainer
import com.example.rickcameras.di.doors.classes.DoorsContainer

class RickApplication:Application() {
    lateinit var camerasAppContainer: CamerasAppContainer
    lateinit var doorsAppContainer: CamerasAppContainer

    override fun onCreate() {
        super.onCreate()
        camerasAppContainer = CamerasContainer()
        doorsAppContainer = DoorsContainer()
    }
}