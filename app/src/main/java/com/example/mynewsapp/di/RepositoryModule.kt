package com.example.mynewsapp.di

import com.example.mynewsapp.data.repository.NewsRepositoryImpl
import com.example.mynewsapp.data.web.NewsApi
import com.example.mynewsapp.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideNewsRepository(api:NewsApi):NewsRepository{
        return NewsRepositoryImpl(api)
    }


}