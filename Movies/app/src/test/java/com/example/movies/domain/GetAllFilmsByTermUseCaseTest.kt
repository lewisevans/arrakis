package com.example.movies.domain

import com.example.movies.domain.fake.FakeFilmRepository
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class GetAllFilmsByTermUseCaseTest {

    private lateinit var sut: GetAllFilmsByTermUseCase

    private val fakeRepo = FakeFilmRepository()

    @Before
    fun setUp() {
        sut = GetAllFilmsByTermUseCase(fakeRepo)
    }

    @Test
    fun testThatInvokeWithValidTermGetsAllMatchingFilms() = runTest {
        val required = fakeRepo.getAllFilmsByTerm("x").first()
        val result = sut.invoke("x").first()
        assertEquals(required, result)
    }

}