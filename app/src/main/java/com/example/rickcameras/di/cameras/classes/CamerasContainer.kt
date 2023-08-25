package com.example.rickcameras.di.cameras.classes

import com.example.rickcameras.di.cameras.interfaces.CamerasAppContainer
import com.example.rickcameras.di.cameras.interfaces.CamerasRepository
import com.example.rickcameras.network.CamerasService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

class CamerasContainer: CamerasAppContainer {

    private val BASE_URL = "http://cars.cprogroup.ru/api/rubetek/cameras/"

    @OptIn(ExperimentalSerializationApi::class)
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(Json.asConverterFactory("json/application".toMediaType()))
        .build()

    private val camerasService: CamerasService by lazy {
        retrofit.create(CamerasService::class.java)
    }


    override val camerasRepository: CamerasRepository by lazy {
        CamerasRepository(retrofit = camerasService)
    }
}