package com.example.rickcameras

import android.app.Application
import com.example.rickcameras.di.container.Container
import com.example.rickcameras.di.container.AppContainer

class RickApplication:Application() {
    lateinit var appContainer: AppContainer

    override fun onCreate() {
        super.onCreate()
        appContainer = Container()
    }
}