package com.example.movies.fake

import com.example.movies.data.DataSource
import com.example.movies.domain.FilmDomainEntity
import kotlinx.coroutines.flow.Flow

class ffFakeLocalDataSource: DataSource {
    override fun getFilms(): Flow<List<FilmDomainEntity>> {
        TODO("Not yet implemented")
    }

    override fun putFilms(items: List<FilmDomainEntity>): Flow<List<FilmDomainEntity>> {
        TODO("Not yet implemented")
    }
}