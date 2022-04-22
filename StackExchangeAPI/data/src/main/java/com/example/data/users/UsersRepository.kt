package com.example.data.users

import com.example.data.api.users.entities.UserApiEntity
import com.example.data.domainResponse
import com.example.domain.DomainResponse
import com.example.domain.user.entity.UserDomainEntity
import com.example.domain.user.UsersRepo

class UsersRepository constructor(
    private val dataSource: UsersDataSource
) : UsersRepo {
    override suspend fun getUsers(searchTerm: String): DomainResponse<List<UserDomainEntity>> =
        domainResponse {
            dataSource.getUsers(searchTerm).items?.map { it.toDoamin() } ?: emptyList()
        }
}

private fun UserApiEntity.toDoamin() = UserDomainEntity(
    accountId = accountId ?: -1,
    badgeCounts = badgeCounts ?: null
)
