package com.example.movies.data

import com.example.movies.domain.FilmDomainEntity
import com.example.movies.fake.FakeFilmRepository
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

@OptIn(ExperimentalCoroutinesApi::class)
class FilmRepositoryImplTest {

    private lateinit var sut: FilmRepositoryImpl

    private val localDataSource: DataSource = mock()
    private val remoteDataSource: DataSource = mock()

    private val fullFlow = flow { emit(FakeFilmRepository.fullList) }
    private val emptyFlow = flow<List<FilmDomainEntity>> { emit(emptyList()) }

    @Before
    fun setUp() {
        sut = FilmRepositoryImpl(
            localDataSource,
            remoteDataSource,
        )
    }

    @Test
    fun `GIVEN there is local data available WHEN we request data THEN do not request it from the remote AND check that the films are returned`() =
        runTest {
            whenever(localDataSource.getFilms()).thenReturn(fullFlow)
            val films = sut.getAllFilms().first()
            /*TEST*/
            verify(localDataSource, times(1)).getFilms()
            verify(remoteDataSource, times(0)).getFilms()
            assertEquals(FakeFilmRepository.fullList, films)
        }

    @Test
    fun `GIVEN there in not local data available WHEN we request data THEN request data from the remote AND store the result in the local datasource AND check that the films are returne`() =
        runTest {
            whenever(localDataSource.getFilms()).thenReturn(emptyFlow)
            whenever(remoteDataSource.getFilms()).thenReturn(fullFlow)
            val films = sut.getAllFilms().first()
            /*TEST*/
            verify(localDataSource, times(1)).getFilms()
            verify(remoteDataSource, times(1)).getFilms()
            verify(localDataSource, times(1)).putFilms(any())
            assertEquals(FakeFilmRepository.fullList, films)
        }
}