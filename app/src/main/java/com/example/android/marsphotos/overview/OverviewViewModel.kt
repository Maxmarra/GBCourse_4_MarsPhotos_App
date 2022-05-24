package com.example.android.marsphotos.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.marsphotos.network.MarsApi
import com.example.android.marsphotos.network.MarsPhoto
import kotlinx.coroutines.launch

//Извлечение и работа с ОДНИМ ОБЪЕКТОМ
//Вывод одной фотки

class OverviewViewModel : ViewModel() {

    private val _status = MutableLiveData<String>()
    val status: LiveData<String> = _status

    private val _photos = MutableLiveData<MarsPhoto>()
    val photos: LiveData<MarsPhoto> = _photos

    init {
        getMarsPhotos()
    }

    private fun getMarsPhotos() {
        viewModelScope.launch {
            try {
                _photos.value = MarsApi.retrofitService.getPhotos()[0]
                _status.value = "First image URL: ${_photos.value!!.imgSrcUrl}"
            } catch (e: Exception) {
                _status.value = "Failure: ${e.message}"
            }
        }
    }
}
