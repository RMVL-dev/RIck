package com.example.rickcameras.data.cameras.utils

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CamerasData (
    @SerialName("room")
    val room:List<String>? = emptyList(),
    @SerialName("cameras")
    val cameras:List<Camera>? = emptyList()
)