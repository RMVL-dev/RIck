package com.example.rickcameras.di.doors.classes

import com.example.rickcameras.di.doors.interfaces.DoorsAppContainer
import com.example.rickcameras.di.doors.interfaces.DoorsRepository
import com.example.rickcameras.network.DoorsService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit


class DoorsContainer:DoorsAppContainer {

    private val BASE_URL = "http://cars.cprogroup.ru/api/rubetek/doors/"

    @OptIn(ExperimentalSerializationApi::class)
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(Json { ignoreUnknownKeys = true }.asConverterFactory("application/json".toMediaType()))
        .build()

    private val doorsService:DoorsService by lazy {
        retrofit.create(DoorsService::class.java)
    }

    override val doorsRepository: DoorsRepository by lazy {
        DoorsRepository(retrofit = doorsService)
    }
}