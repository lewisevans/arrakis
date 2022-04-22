package com.example.domain.user.entity

data class BadgeCountsDomainEntity(
    val bronze: Int,
    val gold: Int,
    val silver: Int,
) {
    companion object {
        val EMPTY = BadgeCountsDomainEntity(
            bronze = -1,
            gold = -1,
            silver = -1,
        )
    }
}