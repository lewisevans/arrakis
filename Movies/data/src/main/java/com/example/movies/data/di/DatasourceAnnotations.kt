package com.example.movies.data.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class LocalDataSourceIdentifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class RemoteDataSourceIdentifier