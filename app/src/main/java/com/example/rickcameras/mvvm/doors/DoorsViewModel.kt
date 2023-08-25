package com.example.rickcameras.mvvm.doors

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickcameras.di.doors.interfaces.DoorsRepository
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException


class DoorsViewModel(
    private val repository: DoorsRepository
):ViewModel() {

    var doorsData:DoorsState by mutableStateOf(DoorsState.Loading)
        private set

    init {
       getDoorsData()
    }

    private fun getDoorsData(){
        viewModelScope.launch {
            doorsData = try {
                DoorsState.Success(
                    doors = repository.getDoorsData()
                )
            }catch (e:IOException){
                DoorsState.Error
            }catch (e:HttpException){
                DoorsState.Error
            }
        }
    }

}