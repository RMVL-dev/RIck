package com.example.rickcameras.mvvm.doors

import com.example.rickcameras.data.doors.Doors

sealed interface DoorsState{

    data class Success( val doors:Doors):DoorsState

    object Loading:DoorsState

    object Error:DoorsState

}