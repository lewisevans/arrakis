package com.example.domain.user.entity

data class UserDomainEntity(
    val accountId: Int,
    val badgeCounts: BadgeCountsDomainEntity,
    val creationDate: Int,
    val displayName: String,
    val isEmployee: Boolean,
    val lastAccessDate: Int,
    val lastModifiedDate: Int,
    val link: String,
    val location: String,
    val profileImage: String,
    val reputation: Int,
    val reputationChangeDay: Int,
    val reputationChangeMonth: Int,
    val reputationChangeQuarter: Int,
    val reputationChangeWeek: Int,
    val reputationChangeYear: Int,
    val userId: Int,
    val userType: String,
    val websiteUrl: String,
) {
    companion object {
        val EMPTY = UserDomainEntity(
            accountId = -1,
            badgeCounts = BadgeCountsDomainEntity.EMPTY,
            creationDate = -1,
            displayName = "",
            isEmployee = false,
            lastAccessDate = -1,
            lastModifiedDate = -1,
            link = "",
            location = "",
            profileImage = "",
            reputation = -1,
            reputationChangeDay = -1,
            reputationChangeMonth = -1,
            reputationChangeQuarter = -1,
            reputationChangeWeek = -1,
            reputationChangeYear = -1,
            userId = -1,
            userType = "",
            websiteUrl = "",
        )
    }
}

