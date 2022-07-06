package com.example.android.marsphotos.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.android.marsphotos.domain.MarsPhotoDomain
import com.squareup.moshi.Json

@Entity(tableName = "marsphotodatabase")
class MarsPhotoDatabase (
    @PrimaryKey
    val id: String,

    @Json(name = "img_src")
    val imgSrc: String
)

fun List<MarsPhotoDatabase>.asDomainModel(): List<MarsPhotoDomain> {
    return map {
        MarsPhotoDomain(
            id = it.id,
            imgSrc = it.imgSrc
        )
    }
}

fun List<MarsPhotoDomain>.asDatabaseModel(): List<MarsPhotoDatabase> {
    return map {
        MarsPhotoDatabase(
            id = it.id,
            imgSrc = it.imgSrc
        )
    }
}
