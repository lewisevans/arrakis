package com.example.movies.domain

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllFilmsByTermUseCase @Inject constructor(
    private val repo: FilmRepository
) {
    operator fun invoke(term: String): Flow<List<FilmDomainEntity>> = repo.getAllFilmsByTerm(term)
}