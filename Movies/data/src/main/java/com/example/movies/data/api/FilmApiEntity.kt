package com.example.movies.data.api

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FilmApiEntity(
    @Json(name = "Title") val title: String?,
    @Json(name = "Poster") val poster: String?,
    @Json(name = "Genre") val genre: String?,
)
