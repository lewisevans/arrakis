package com.example.movies.domain

data class FilmDomainEntity(
    val title: String,
    val poster: String,
    val genre: List<String>,
)
