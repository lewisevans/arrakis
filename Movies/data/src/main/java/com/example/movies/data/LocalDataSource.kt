package com.example.movies.data

import androidx.collection.LruCache
import com.example.movies.domain.FilmDomainEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class LocalDataSource @Inject constructor() : DataSource {

    var lruCache: LruCache<String, List<FilmDomainEntity>> = LruCache(1 * 1024 * 1024)

    override fun getFilms(): Flow<List<FilmDomainEntity>> = flow {
        val items = lruCache.get(LUR_KEY_FILMS) ?: emptyList()
        emit(items)
    }

    override fun putFilms(items: List<FilmDomainEntity>): Flow<List<FilmDomainEntity>> =
        flow {
            val films = lruCache.put(LUR_KEY_FILMS, items) ?: emptyList()
            emit(films)
        }

}

const val LUR_KEY_FILMS: String = "lur_key_films"
