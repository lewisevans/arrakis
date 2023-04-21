package com.example.movies.data

import com.example.movies.data.api.FilmApiEntity
import com.example.movies.data.api.FilmService
import com.example.movies.domain.FilmDomainEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val service: FilmService
) : DataSource {
    override fun getFilms(): Flow<List<FilmDomainEntity>> =
        flow {
            emit(service.getFilms().map { it.toDomain() })
        }

    override fun putFilms(items: List<FilmDomainEntity>): Flow<List<FilmDomainEntity>> = flow {
        /*NOT USED IN REMOTE YET*/
        emit(emptyList())
    }
}

private fun FilmApiEntity.toDomain() = FilmDomainEntity(
    title = title ?: "No title provided",
    genre = genre?.split(",")?.onEach { it.trim() } ?: emptyList()
)
