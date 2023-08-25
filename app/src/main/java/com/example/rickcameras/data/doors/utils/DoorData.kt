package com.example.rickcameras.data.doors.utils

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DoorData(
    @SerialName("name")
    val name:String? = null,
    @SerialName("room")
    val room:String? = null,
    @SerialName("id")
    val id:Int? = null,
    @SerialName("favorites")
    val favorites:Boolean? = null,
)