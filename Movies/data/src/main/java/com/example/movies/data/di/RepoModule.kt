package com.example.movies.data.di

import com.example.movies.data.DataSource
import com.example.movies.data.FilmRepositoryImpl
import com.example.movies.data.LocalDataSource
import com.example.movies.data.RemoteDataSource
import com.example.movies.domain.FilmRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepoModule {

    @Binds
    abstract fun bindFilmRepository(
        repositoryImpl: FilmRepositoryImpl
    ): FilmRepository

    @RemoteDataSourceIdentifier
    @Binds
    abstract fun bindFilmRemoteDataSource(
        dataSource: RemoteDataSource
    ): DataSource

    @LocalDataSourceIdentifier
    @Binds
    abstract fun bindFilmLocalDataSource(
        dataSource: LocalDataSource
    ): DataSource

}
