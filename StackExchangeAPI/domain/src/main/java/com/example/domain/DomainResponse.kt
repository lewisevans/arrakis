package com.example.domain

// TODO: Make Error() return a Typed Domain error object
sealed class DomainResponse<out T : Any> {
    object Loading : DomainResponse<Nothing>()
    data class Content<out T : Any>(val result: T) : DomainResponse<T>()
    data class Error(val code: Int, val message: String) : DomainResponse<Nothing>()
}