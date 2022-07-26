package com.example.android.marsphotos.database
import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface MovieDao {

    @Query("select * from movie_database")
    fun getMovies(): LiveData<List<DatabaseMovie>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllMovies( movies: List<DatabaseMovie>)
}



@Database(entities = [DatabaseMovie::class], version = 1, exportSchema = false)
abstract class MovieDatabase: RoomDatabase() {

    abstract val movieDao: MovieDao
}

private lateinit var INSTANCE: MovieDatabase

fun getDatabase(context: Context): MovieDatabase {
    synchronized(MovieDatabase::class.java) {
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(context.applicationContext,
                MovieDatabase::class.java,
                    "videos").build()
        }
    }
    return INSTANCE
}
