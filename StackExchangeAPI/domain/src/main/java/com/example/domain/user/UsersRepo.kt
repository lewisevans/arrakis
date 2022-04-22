package com.example.domain.user

import com.example.domain.DomainResponse
import com.example.domain.user.entity.UserDomainEntity

interface UsersRepo {
    suspend fun getUsers(searchTerm: String): DomainResponse<List<UserDomainEntity>>
}