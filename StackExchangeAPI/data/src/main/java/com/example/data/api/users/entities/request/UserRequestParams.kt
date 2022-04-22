package com.example.data.api.users.entities.request

data class UserRequestParams(
    val page: Int = 1,
    val pagesize: Int = 20,
    val order: String = "desc",
    val sort: String = "name",
    val inname: String = "droppin_science",
    val site: String = "stackoverflow",
)
