package com.example.android.marsphotos.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.android.marsphotos.model.ModelMovie

@Entity
data class DatabaseMovie (

    @PrimaryKey
    val id: Int,
    val title: String,
    val posterPath: String
)
// грузим из базы, когда нет интернета!
// разрул в репозитории
fun List<DatabaseMovie>.asDomainModelFromDb() : List<ModelMovie>{
    return map {
        ModelMovie(
            id = it.id,
            title = it.title,
            posterPath = it.posterPath
        )
    }
}