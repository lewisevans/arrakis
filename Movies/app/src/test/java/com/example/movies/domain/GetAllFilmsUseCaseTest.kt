package com.example.movies.domain

import com.example.movies.domain.fake.FakeFilmRepository
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test


@OptIn(ExperimentalCoroutinesApi::class)
class GetAllFilmsUseCaseTest {

    /* ONLY TESTING HAPPY PATH NOT THROWABLE*/

    private lateinit var sut: GetAllFilmsUseCase

    private val fakeRepo = FakeFilmRepository()

    @Before
    fun setUp() {
        sut = GetAllFilmsUseCase(fakeRepo)
    }

    @Test
    fun testThatInvokeGetsAllFilms() = runTest {
        assertEquals(FakeFilmRepository.fullList, sut.invoke().first())
    }

}