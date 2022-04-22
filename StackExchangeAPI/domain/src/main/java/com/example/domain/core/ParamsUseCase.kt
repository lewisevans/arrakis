package com.example.domain.core

import com.example.domain.DomainResponse

interface ParamsUseCase<P, out T : Any> {
    suspend fun execute(params: P): DomainResponse<T>
}