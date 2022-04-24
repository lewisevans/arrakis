package com.example.data.api.users

import com.example.data.api.users.entities.BadgeCountsApiEntity
import com.example.data.api.users.entities.UserApiEntity
import com.example.domain.core.EMPTY
import com.example.domain.user.entity.BadgeCountsDomainEntity
import com.example.domain.user.entity.UserDomainEntity

fun UserApiEntity.toDomain() = UserDomainEntity(
    accountId = accountId ?: Int.EMPTY,
    badgeCounts = badgeCounts?.toDomain() ?: BadgeCountsDomainEntity.EMPTY,
    creationDate = creationDate ?: Int.EMPTY,
    displayName = displayName ?: String.EMPTY,
    isEmployee = isEmployee ?: false,
    lastAccessDate = lastAccessDate ?: Int.EMPTY,
    lastModifiedDate = lastModifiedDate ?: Int.EMPTY,
    link = link ?: String.EMPTY,
    location = location ?: String.EMPTY,
    profileImage = profileImage ?: String.EMPTY,
    reputation = reputation ?: Int.EMPTY,
    reputationChangeDay = reputationChangeDay ?: Int.EMPTY,
    reputationChangeMonth = reputationChangeMonth ?: Int.EMPTY,
    reputationChangeQuarter = reputationChangeQuarter ?: Int.EMPTY,
    reputationChangeWeek = reputationChangeWeek ?: Int.EMPTY,
    reputationChangeYear = reputationChangeYear ?: Int.EMPTY,
    userId = userId ?: Int.EMPTY,
    userType = userType ?: String.EMPTY,
    websiteUrl = websiteUrl ?: String.EMPTY
)

fun BadgeCountsApiEntity.toDomain() = BadgeCountsDomainEntity(
    bronze = bronze ?: Int.EMPTY,
    gold = gold ?: Int.EMPTY,
    silver = silver ?: Int.EMPTY
)
