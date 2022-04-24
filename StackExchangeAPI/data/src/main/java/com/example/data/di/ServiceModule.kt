package com.example.data.di

import com.example.data.api.StackExchangeApiService
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
    fun provideService(retrofit: Retrofit): StackExchangeApiService =
        retrofit
            .newBuilder()
            .baseUrl("https://api.stackexchange.com/2.3/")
            .build()
            .create(StackExchangeApiService::class.java)

}