package com.example.data.api.users

import com.example.data.api.StackExchangeApiService
import com.example.domain.user.entity.UserDomainEntity
import javax.inject.Inject

class UsersDataSource @Inject constructor(
    private val service: StackExchangeApiService,
) {
    suspend fun getUsers(searchTerm: String): List<UserDomainEntity> = service.getUsers(
        page = 1,
        pageSize = 20,
        order = "desc",
        sort = "name",
        inName = searchTerm,
        site = "stackoverflow"
    ).items?.map {
        it.toDomain()
    } ?: emptyList()
}