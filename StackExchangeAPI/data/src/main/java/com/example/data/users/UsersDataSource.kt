package com.example.data.users

import com.example.data.api.StackExchangeApiService
import javax.inject.Inject

class UsersDataSource @Inject constructor(
    private val service: StackExchangeApiService,
) {
    suspend fun getUsers(searchTerm: String) = service.getUsers(
        page = 1,
        pageSize = 20,
        order = "desc",
        sort = "name",
        inName = searchTerm,
        site = "stackoverflow"
    )
}