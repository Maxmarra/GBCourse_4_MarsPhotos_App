package com.example.mars_3_drilling.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mars_3_drilling.network.MarsApi
import com.example.mars_3_drilling.network.MarsPhoto
import kotlinx.coroutines.launch

enum class ConnectionStatus{
    LOADING, DONE, ERROR
}

class MarsViewModel: ViewModel() {

    private val _photos = MutableLiveData<List<MarsPhoto>>()
    val photos : LiveData<List<MarsPhoto>> = _photos

    private val _status = MutableLiveData<ConnectionStatus>()
    val status : LiveData<ConnectionStatus> = _status

    init {
        getMarsPhotos()
    }

    private fun getMarsPhotos(){

        _status.value = ConnectionStatus.LOADING

        viewModelScope.launch {
            try {
                _photos.value = MarsApi.retrofitService.getPhotos()
                _status.value = ConnectionStatus.DONE
                Log.d("MarViewModel", "${photos.value?.size}")
            }catch (e:Exception){
                _status.value = ConnectionStatus.ERROR
                Log.d("MarViewModel", "$e")
                _photos.value = listOf()

            }
        }
    }

}