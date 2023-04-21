package com.example.movies.data

import com.example.movies.domain.FilmDomainEntity
import kotlinx.coroutines.flow.Flow

interface DataSource {
    fun getFilms(): Flow<List<FilmDomainEntity>>
    fun putFilms(items: List<FilmDomainEntity>): Flow<List<FilmDomainEntity>>
}