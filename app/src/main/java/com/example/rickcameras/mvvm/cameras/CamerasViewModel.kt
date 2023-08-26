package com.example.rickcameras.mvvm.cameras

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickcameras.di.repositories.interfaces.CamerasRepository
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class CamerasViewModel(
    private val repository: CamerasRepository
):ViewModel() {

    var camerasData:CamerasState by mutableStateOf(CamerasState.Loading)
        private set

    init {
        getCamerasData()
    }

    private fun getCamerasData(){
        viewModelScope.launch {
            camerasData =  try {
                CamerasState.Success(
                    repository.getCamerasData()
                )
            }
            catch (e:HttpException){
                CamerasState.Error
            }catch (e:IOException){
                CamerasState.Error
            }
        }
    }
}