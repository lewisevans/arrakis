package com.example.movies.fake

import com.example.movies.domain.FilmDomainEntity
import com.example.movies.domain.FilmRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeFilmRepository : FilmRepository {

    override fun getAllFilms(): Flow<List<FilmDomainEntity>> =
        flow {
            emit(fullList)
        }

    override fun getAllFilmsByTerm(term: String): Flow<List<FilmDomainEntity>> =
        flow {
            emit(
                fullList.filter { entity ->
                    entity.title.contains(term, true) ||
                            entity.genre.any { genre ->
                                genre.contains(
                                    term, true
                                )
                            }
                }
            )
        }

    companion object {
        val fullList: List<FilmDomainEntity> = listOf(
            FilmDomainEntity("Film 1", listOf("a", "b", "c")),
            FilmDomainEntity("Film 2", listOf("x", "y", "z")),
            FilmDomainEntity("Film 3", listOf("a", "b", "c")),
            FilmDomainEntity("Film 4", listOf("x", "y", "z")),
            FilmDomainEntity("Film X", listOf("a", "b", "c")),
            FilmDomainEntity("Film Y", listOf("a", "b", "c")),
        )
    }
}