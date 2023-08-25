package com.example.rickcameras.provider

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.rickcameras.RickApplication
import com.example.rickcameras.mvvm.cameras.CamerasViewModel


object AppViewModelProvider {
    val Factory = viewModelFactory {
        initializer {
            CamerasViewModel(repository = rickApplication().camerasAppContainer.camerasRepository)
        }
    }
}

fun CreationExtras.rickApplication(): RickApplication =
    this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as RickApplication