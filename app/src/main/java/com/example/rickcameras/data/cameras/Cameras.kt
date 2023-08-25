package com.example.rickcameras.data.cameras

import com.example.rickcameras.data.cameras.utils.CamerasData
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Cameras(
    @SerialName("success")
    val success:Boolean,
    @SerialName("data")
    val data: CamerasData
)
