package com.example.data.users

import com.example.data.api.users.UsersDataSource
import com.example.domain.DomainResponse
import com.example.domain.user.entity.UserDomainEntity
import kotlinx.coroutines.runBlocking

import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.kotlin.mock

class UsersRepositoryTest {

    private val dataSource: UsersDataSource = mock()
    private val unitUnderTest: UsersRepository = UsersRepository(dataSource)

    private val searchTerm = "hello"
    private val listOfDomainEntities = listOf(
        UserDomainEntity.EMPTY.copy(displayName = "hello you"),
        UserDomainEntity.EMPTY.copy(displayName = "hello me"),
    )
    private val errorResponse = DomainResponse.Error(500, "An Error Occurred")

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun `GIVEN I am searching for a user WHEN data is present in the dataSource THEN test the DomainResponse object is constructed correctly`() = runBlocking {
        setupSuccess()
        val result = unitUnderTest.getUsers(searchTerm)
        Assert.assertTrue(result is DomainResponse.Content<List<UserDomainEntity>>)
    }

    private suspend fun setupSuccess() {
        Mockito.`when`(dataSource.getUsers(searchTerm)).thenReturn(
            listOf(UserDomainEntity.EMPTY, UserDomainEntity.EMPTY)
        )
    }

}