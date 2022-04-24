package com.example.data.users

import com.example.data.api.users.UsersDataSource
import com.example.data.api.users.toDomain
import com.example.data.domainResponse
import com.example.domain.DomainResponse
import com.example.domain.user.UsersRepo
import com.example.domain.user.entity.UserDomainEntity
import javax.inject.Inject

class UsersRepository @Inject constructor(
    private val dataSource: UsersDataSource
) : UsersRepo {
    override suspend fun getUsers(searchTerm: String): DomainResponse<List<UserDomainEntity>> =
        domainResponse {
            dataSource.getUsers(searchTerm)
        }
}
