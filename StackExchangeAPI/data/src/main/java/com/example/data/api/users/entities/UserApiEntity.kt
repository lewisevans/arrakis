package com.example.data.api.users.entities


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserApiEntity(
    @Json(name = "account_id") val accountId: Int?,
    @Json(name = "badge_counts") val badgeCounts: BadgeCountsApiEntity?,
    @Json(name = "creation_date") val creationDate: Int?,
    @Json(name = "display_name") val displayName: String?,
    @Json(name = "is_employee") val isEmployee: Boolean?,
    @Json(name = "last_access_date") val lastAccessDate: Int?,
    @Json(name = "last_modified_date") val lastModifiedDate: Int?,
    @Json(name = "link") val link: String?,
    @Json(name = "location") val location: String?,
    @Json(name = "profile_image") val profileImage: String?,
    @Json(name = "reputation") val reputation: Int?,
    @Json(name = "reputation_change_day") val reputationChangeDay: Int?,
    @Json(name = "reputation_change_month") val reputationChangeMonth: Int?,
    @Json(name = "reputation_change_quarter") val reputationChangeQuarter: Int?,
    @Json(name = "reputation_change_week") val reputationChangeWeek: Int?,
    @Json(name = "reputation_change_year") val reputationChangeYear: Int?,
    @Json(name = "user_id") val userId: Int?,
    @Json(name = "user_type") val userType: String?,
    @Json(name = "website_url") val websiteUrl: String?
)