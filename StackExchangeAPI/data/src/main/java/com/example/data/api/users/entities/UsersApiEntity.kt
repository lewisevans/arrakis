package com.example.data.api.users.entities


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UsersApiEntity(
    @Json(name = "has_more") val hasMore: Boolean?,
    @Json(name = "items") val items: List<UserApiEntity>?,
    @Json(name = "quota_max") val quotaMax: Int?,
    @Json(name = "quota_remaining") val quotaRemaining: Int?
)