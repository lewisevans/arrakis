package com.example.data

import com.example.domain.DomainResponse
import retrofit2.HttpException

suspend fun <T : Any> domainResponse(result: suspend () -> T) =
    try {
        DomainResponse.Content(result())
    } catch (e: HttpException) {
        DomainResponse.Error(e.code(), e.localizedMessage ?: "Http Error")
    } catch (e: Exception) {
        // TODO Change with something ...
        DomainResponse.Error(999, e.localizedMessage ?: "Unknown Error")
    }

