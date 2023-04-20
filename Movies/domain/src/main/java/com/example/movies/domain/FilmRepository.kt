package com.example.movies.domain

import kotlinx.coroutines.flow.Flow

interface FilmRepository {
    fun getAllFilms(): Flow<List<FilmDomainEntity>>
    fun getAllFilmsByTerm(term: String): Flow<List<FilmDomainEntity>>
}