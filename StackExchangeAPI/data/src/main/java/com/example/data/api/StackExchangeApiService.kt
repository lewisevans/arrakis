package com.example.data.api

import com.example.data.api.users.entities.UsersApiEntity
import retrofit2.http.GET
import retrofit2.http.Query

interface StackExchangeApiService {
    @GET("users")
    suspend fun getUsers(
        @Query("page") page: Int,
        @Query("pagesize") pageSize: Int,
        @Query("order") order: String,
        @Query("sort") sort: String,
        @Query("inname") inName: String,
        @Query("site") site: String,
    ): UsersApiEntity
}