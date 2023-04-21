package com.example.movies.data

import com.example.movies.data.di.LocalDataSourceIdentifier
import com.example.movies.data.di.RemoteDataSourceIdentifier
import com.example.movies.domain.FilmDomainEntity
import com.example.movies.domain.FilmRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class FilmRepositoryImpl @Inject constructor(
    @LocalDataSourceIdentifier private val localDataSource: DataSource,
    @RemoteDataSourceIdentifier private val remoteDataSource: DataSource,
) : FilmRepository {

    override fun getAllFilms(): Flow<List<FilmDomainEntity>> = flow {
        localDataSource.getFilms().onEach { localEntities ->
            if (localEntities.isEmpty()) {
                remoteDataSource.getFilms().onEach { remoteEntities ->
                    localDataSource.putFilms(remoteEntities)
                    emit(remoteEntities)
                }.collect()
            } else {
                emit(localEntities)
            }
        }.collect()
    }


    override fun getAllFilmsByTerm(term: String): Flow<List<FilmDomainEntity>> =
        getAllFilms().map { remoteEntities ->
            remoteEntities.filter { entity ->
                entity.title.contains(term, true) ||
                        entity.genre.any { genre ->
                            genre.contains(
                                term, true
                            )
                        }
            }
        }

}
