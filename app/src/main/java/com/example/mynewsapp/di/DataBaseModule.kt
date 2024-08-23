package com.example.mynewsapp.di

import android.content.Context
import com.example.mynewsapp.data.database.NewsDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {

    @Provides
    @Singleton
    fun provideDataBase(context: Context):NewsDataBase{
        return NewsDataBase.getDatabase(context)
    }

}