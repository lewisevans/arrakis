package com.example.movies.data.di

import com.example.movies.data.api.FilmService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Provides
    @Singleton
    fun provideService(retrofit: Retrofit): FilmService =
        retrofit
            .newBuilder()
            .baseUrl("https://api.npoint.io/")
            .build()
            .create(FilmService::class.java)

}