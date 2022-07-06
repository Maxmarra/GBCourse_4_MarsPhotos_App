package com.example.android.marsphotos.database

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface MarsDao {
    @Query("select * from marsphotodatabase")
    fun getPhotos(): LiveData<List<MarsPhotoDatabase>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll( photos: List<MarsPhotoDatabase>)
}



@Database(entities = [MarsPhotoDatabase::class], version = 1)
abstract class PhotosDatabase: RoomDatabase() {
    abstract val marsDao: MarsDao
}

private lateinit var INSTANCE: PhotosDatabase

fun getDatabase(context: Context): PhotosDatabase {
    synchronized(PhotosDatabase::class.java) {
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(context.applicationContext,
                PhotosDatabase::class.java,
                "photos").build()
        }
    }
    return INSTANCE
}
