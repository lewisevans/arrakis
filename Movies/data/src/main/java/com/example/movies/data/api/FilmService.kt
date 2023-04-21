package com.example.movies.data.api

import retrofit2.http.GET

interface FilmService {
    @GET("759fdfa82d6f33522e11")
    suspend fun getFilms(): List<FilmApiEntity>
}