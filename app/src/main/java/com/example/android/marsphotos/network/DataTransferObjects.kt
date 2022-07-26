package com.example.android.marsphotos.network

import com.example.android.marsphotos.database.DatabaseMovie
import com.example.android.marsphotos.model.ModelMovie
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Results(
    @Json(name = "results")
    val popularMovies: List<NetworkMovie>
)
@JsonClass(generateAdapter = true)
data class NetworkMovie(
    val id: Int,
    val title: String,
    @Json(name = "poster_path")
    val posterPath: String

)

fun Results.asDomainModel(): List<ModelMovie>{
    return popularMovies.map {
        ModelMovie(
            id = it.id,
            title = it.title,
            posterPath = it.posterPath
        )
    }
}

fun Results.asDatabaseModel(): List<DatabaseMovie>{
    return popularMovies.map {
        DatabaseMovie(
            id = it.id,
            title = it.title,
            posterPath = it.posterPath
        )
    }
}




/*
* {
  "page": 1,
  "results": [
    {
      "poster_path": "/e1mjopzAS2KNsvpbpahQ1a6SkSn.jpg",
      "adult": false,
      "overview": "From DC Comics comes the Suicide Squad, an antihero team of incarcerated supervillains who act as deniable assets for the United States government, undertaking high-risk black ops missions in exchange for commuted prison sentences.",
      "release_date": "2016-08-03",
      "genre_ids": [
        14,
        28,
        80
      ],
      "id": 297761,
      "original_title": "Suicide Squad",
      "original_language": "en",
      "title": "Suicide Squad",
      "backdrop_path": "/ndlQ2Cuc3cjTL7lTynw6I4boP4S.jpg",
      "popularity": 48.261451,
      "vote_count": 1466,
      "video": false,
      "vote_average": 5.91
    },
    {
      "poster_path": "/lFSSLTlFozwpaGlO31OoUeirBgQ.jpg",
      "adult": false,
      "overview": "The most dangerous former operative of the CIA is drawn out of hiding to uncover hidden truths about his past.",
      "release_date": "2016-07-27",
      "genre_ids": [
        28,
        53
      ],
      "id": 324668,
      "original_title": "Jason Bourne",
      "original_language": "en",
      "title": "Jason Bourne",
      "backdrop_path": "/AoT2YrJUJlg5vKE3iMOLvHlTd3m.jpg",
      "popularity": 30.690177,
      "vote_count": 649,
      "video": false,
      "vote_average": 5.25
    },*/



