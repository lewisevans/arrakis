package com.example.domain.core

import com.example.domain.DomainResponse

interface UseCase<out T : Any> {
    suspend fun execute(): DomainResponse<T>
}