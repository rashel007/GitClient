package com.learn.gitclient.di

import com.learn.gitclient.network.ApiService
import com.learn.gitclient.repository.DataRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

@InstallIn(ActivityRetainedComponent::class)
@Module
object RepositoryModule {


    @ActivityRetainedScoped
    @Provides
    fun provideRepository(apiService: ApiService): DataRepository{
        return DataRepository(apiService)
    }
}