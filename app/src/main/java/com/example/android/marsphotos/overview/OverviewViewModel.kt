package com.example.android.marsphotos.overview

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.android.marsphotos.database.getDatabase
import com.example.android.marsphotos.domain.MarsPhotoDomain
import com.example.android.marsphotos.repository.MarsRepository
import kotlinx.coroutines.launch

enum class MarsApiStatus { LOADING, ERROR, DONE }

class OverviewViewModel(application: Application)
    : AndroidViewModel(application) {

    //все фото получены из репозитория
    //сначала программа проверила наличие данных в базе
    //и если там что-то есть - загрузила их
    //- инициализировали repo
    //- получили из repo готовые фотки(либо из базы, либо из сети)
    private val photosRepository = MarsRepository(getDatabase(application))
    val photos = photosRepository.photos

    private var _status = MutableLiveData<MarsApiStatus>()
    val status: LiveData<MarsApiStatus> = _status

    private var _photo = MutableLiveData<MarsPhotoDomain>()
    val photo: LiveData<MarsPhotoDomain> = _photo

//    private var _photos = MutableLiveData<List<MarsPhoto>>()
//    val photos: LiveData<List<MarsPhoto>> = _photos


    fun getMarsPhotos() {
        _status.value = MarsApiStatus.LOADING
        viewModelScope.launch {
            try {
                //запросили обновление данных
                photosRepository.refreshPhotos()
                _status.value = MarsApiStatus.DONE
            } catch (e: Exception) {
                _status.value = MarsApiStatus.ERROR

            }
        }
    }

    fun onPhotoClicked(marsPhoto: MarsPhotoDomain) {
        _photo.value = marsPhoto
    }
}
