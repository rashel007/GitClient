package com.learn.gitclient.di

import com.learn.gitclient.repository.DataRepository
import com.learn.gitclient.repository.DataUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

@InstallIn(ActivityRetainedComponent::class)
@Module
object UserDataUseModule {


    @ActivityRetainedScoped
    @Provides
    fun provideUserDataUseCase(dataRepository: DataRepository): DataUseCase {
        return DataUseCase(dataRepository)
    }
}