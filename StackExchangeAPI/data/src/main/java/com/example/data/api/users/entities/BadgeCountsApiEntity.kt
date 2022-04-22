package com.example.data.api.users.entities


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BadgeCountsApiEntity(
    @Json(name = "bronze") val bronze: Int?,
    @Json(name = "gold") val gold: Int?,
    @Json(name = "silver") val silver: Int?
)