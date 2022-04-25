package com.example.presentation.users

import com.example.domain.DomainResponse
import com.example.domain.user.GetUsersUseCase
import org.junit.Assert
import org.junit.Test
import org.mockito.kotlin.mock

class UsersViewModelTest {

    private val useCase: GetUsersUseCase = GetUsersUseCase(mock())
    private val unitUnderTest: UsersViewModel = UsersViewModel(useCase)

    @Test
    fun `GIVEN we request users from the useCase WHEN I the useCase returns a valid result THEN return the correct result`() {
        val loading = unitUnderTest.getUsers("").getOrAwaitValue()
        Assert.assertEquals(loading, DomainResponse.Loading)
    }
}