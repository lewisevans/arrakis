package com.example.movies.presentation.search

import com.example.movies.domain.FilmDomainEntity

data class ViewModelState(
    val searchText: String = "",
    val results: List<FilmDomainEntity> = emptyList()
)
