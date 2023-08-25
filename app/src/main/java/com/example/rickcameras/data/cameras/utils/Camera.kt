package com.example.rickcameras.data.cameras.utils

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Camera(
    @SerialName("name")
    val name:String? = null,
    @SerialName("snapshot")
    val snapshot:String? = null,
    @SerialName("room")
    val room:String? = null,
    @SerialName("id")
    val id:Int? = null,
    @SerialName("favorites")
    val favorites:Boolean? = null,
    @SerialName("rec")
    val rec:Boolean? = null,
)
