package movies.fake

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
            FilmDomainEntity("Film 1", "poster", listOf("a", "b", "c")),
            FilmDomainEntity("Film 2", "poster", listOf("x", "y", "z")),
            FilmDomainEntity("Film 3", "poster", listOf("a", "b", "c")),
            FilmDomainEntity("Film 4", "poster", listOf("x", "y", "z")),
            FilmDomainEntity("Film X", "poster", listOf("a", "b", "c")),
            FilmDomainEntity("Film Y", "poster", listOf("a", "b", "c")),
        )
    }
}