package com.example.rickcameras.di.container

import com.example.rickcameras.di.repositories.interfaces.CamerasRepository
import com.example.rickcameras.di.repositories.interfaces.DoorsRepository
import com.example.rickcameras.network.CamerasService
import com.example.rickcameras.network.DoorsService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

class Container: AppContainer {

    private val CAMERAS_BASE_URL = "http://cars.cprogroup.ru/api/rubetek/cameras/"
    private val DOORS_BASE_URL = "http://cars.cprogroup.ru/api/rubetek/doors/"

    @OptIn(ExperimentalSerializationApi::class)
    private val json = Json { ignoreUnknownKeys = true }.asConverterFactory("json/application".toMediaType())

    private val camerasRetrofit = Retrofit.Builder()
        .baseUrl(CAMERAS_BASE_URL)
        .addConverterFactory(json)
        .build()

    private val doorsRetrofit = Retrofit.Builder()
        .baseUrl(DOORS_BASE_URL)
        .addConverterFactory(json)
        .build()

    private val doorsService:DoorsService by lazy {
        doorsRetrofit.create(DoorsService::class.java)
    }
    private val camerasService: CamerasService by lazy {
        camerasRetrofit.create(CamerasService::class.java)
    }


    override val camerasRepository: CamerasRepository by lazy {
        com.example.rickcameras.di.repositories.classes.CamerasRepository(retrofit = camerasService)
    }
    override val doorsRepository: DoorsRepository by lazy {
        com.example.rickcameras.di.repositories.classes.DoorsRepository(retrofit = doorsService)
    }
}