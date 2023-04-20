package com.example.movies.domain

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllFilmsUseCase @Inject constructor(
    private val repo: FilmRepository
) {
    operator fun invoke(): Flow<List<FilmDomainEntity>> = repo.getAllFilms()
}