package com.example.domain.user

import com.example.domain.DomainResponse
import com.example.domain.core.ParamsUseCase
import com.example.domain.user.entity.UserDomainEntity
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(
    private val repo: UsersRepo
) : ParamsUseCase<String, List<UserDomainEntity>> {
    override suspend fun execute(params: String): DomainResponse<List<UserDomainEntity>> =
        repo.getUsers(params)
}