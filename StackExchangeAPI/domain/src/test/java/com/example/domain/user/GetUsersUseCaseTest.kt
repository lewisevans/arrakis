package com.example.domain.user

import com.example.domain.DomainResponse
import com.example.domain.user.entity.UserDomainEntity
import kotlinx.coroutines.runBlocking
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import org.junit.Assert.*
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.mockito.kotlin.any

class GetUsersUseCaseTest {

    private val repo = mock(UsersRepo::class.java)
    private val unitUnderTest: GetUsersUseCase = GetUsersUseCase(repo)

    private val listOfDomainEntities = listOf(
        UserDomainEntity.EMPTY.copy(displayName = "hello you"),
        UserDomainEntity.EMPTY.copy(displayName = "hello me"),
    )

    private val errorResponse = DomainResponse.Error(500, "An Error Occurred")

    @org.junit.Before
    fun setUp() {
        runBlocking {

        }
    }

    @org.junit.After
    fun tearDown() {
    }

    @Test
    fun `GIVEN I am searching for a term WHEN data is present THEN return a correct 'Content' result`() = runBlocking {
        setupSuccess()
        val result = unitUnderTest.execute(SEARCH_TERM)
        assertTrue(result is DomainResponse.Content)
        when(result){
            is DomainResponse.Content -> {
                val listResult:List<UserDomainEntity>  = result.result
                assertThat(listResult, equalTo(listOfDomainEntities))
            }
        }
    }

    @Test
    fun `GIVEN I am searching for a term WHEN data is not present THEN return 'Error'`() = runBlocking {
        setupFail()
        val result = unitUnderTest.execute(SEARCH_TERM)
        assertTrue(result is DomainResponse.Error)
        when(result){
            is DomainResponse.Error -> {
                assertThat(result, equalTo(errorResponse))
            }
        }
    }

    private suspend fun setupSuccess() {
        `when`(repo.getUsers(SEARCH_TERM)).thenReturn(
            DomainResponse.Content(
                listOfDomainEntities
            )
        )
    }

    private suspend fun setupFail() {
        `when`(repo.getUsers(any())).thenReturn(
            errorResponse
        )
    }

}

private const val SEARCH_TERM = "hello"