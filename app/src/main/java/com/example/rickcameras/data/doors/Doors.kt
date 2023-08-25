package com.example.rickcameras.data.doors

import com.example.rickcameras.data.doors.utils.DoorData
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Doors(
    @SerialName("success")
    val success:Boolean,
    @SerialName("data")
    val data: List<DoorData>? = emptyList()
)
