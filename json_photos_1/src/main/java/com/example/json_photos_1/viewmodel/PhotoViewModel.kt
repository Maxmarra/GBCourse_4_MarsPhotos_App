package com.example.json_photos_1.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.json_photos_1.network.Photo
import com.example.json_photos_1.network.PhotoApi
import com.example.json_photos_1.network.PhotoApiService
import kotlinx.coroutines.launch


enum class ConnectionStatus{
    LOADING, DONE, ERROR
}

class PhotoViewModel: ViewModel() {

    private val _photos = MutableLiveData<List<Photo>>()
    val photos: LiveData<List<Photo>> = _photos

    private val _status = MutableLiveData<ConnectionStatus>()
    val status: LiveData<ConnectionStatus> = _status

    init {
        getPhotos()
    }

    private fun getPhotos(){

        _status.value = ConnectionStatus.LOADING

        viewModelScope.launch {
            try {
                _photos.value = PhotoApi.retrofitService.getPhotos()
                //Log.d("PhotoViewModel", "${photos.value?.size}")
                _status.value = ConnectionStatus.DONE
            }catch (e:Exception){
                //Log.e("PhotoViewModel", "${e.message}")
                _status.value = ConnectionStatus.ERROR
                _photos.value = listOf()
            }
        }
    }

}