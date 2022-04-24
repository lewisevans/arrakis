package com.example.data.di

import com.example.data.users.UsersRepository
import com.example.domain.user.UsersRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepoModule {

    @Binds
    abstract fun bindItemRepository(
        repositoryImpl: UsersRepository
    ): UsersRepo

}
