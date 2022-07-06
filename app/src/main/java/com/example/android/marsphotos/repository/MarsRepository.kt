package com.example.android.marsphotos.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.android.marsphotos.database.MarsPhotoDatabase
import com.example.android.marsphotos.database.PhotosDatabase
import com.example.android.marsphotos.database.asDatabaseModel
import com.example.android.marsphotos.database.asDomainModel
import com.example.android.marsphotos.domain.MarsPhotoDomain
import com.example.android.marsphotos.network.MarsApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MarsRepository(private val database: PhotosDatabase) {

    suspend fun refreshPhotos() {
        withContext(Dispatchers.IO) {
            //получили фотки из сети
            val photos = MarsApi.retrofitService.getPhotos()

            //внесли их в базу в виде объектов MarsPhotoDatabase
            database.marsDao.insertAll(photos.asDatabaseModel())

        }
    }

    //запрашиваем фотки из базы и приводим их к модели MarsPhotoDomain
    // данный результат запрашиваем во OverviewViewModel
    val photos: LiveData<List<MarsPhotoDomain>> =
        Transformations.map(database.marsDao.getPhotos()) {
            it.asDomainModel()
        }
}