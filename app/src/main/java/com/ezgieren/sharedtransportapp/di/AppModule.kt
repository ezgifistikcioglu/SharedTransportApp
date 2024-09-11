package com.ezgieren.sharedtransportapp.di

import com.ezgieren.sharedtransportapp.data.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideUserRepository(): UserRepository {
        return UserRepository()
    }
}