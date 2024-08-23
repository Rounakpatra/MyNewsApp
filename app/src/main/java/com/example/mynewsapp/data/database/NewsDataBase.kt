package com.example.mynewsapp.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mynewsapp.data.dao.NewsDao
import com.example.mynewsapp.data.model.News

@Database(entities = [News::class], version = 1, exportSchema = false)
abstract class NewsDataBase : RoomDatabase() {

    abstract fun newsDao(): NewsDao

    companion object {

        const val DATABASE_NAME = "news_db"

        @JvmStatic
        fun getDatabase(context: Context): NewsDataBase {
            return Room.databaseBuilder(context, NewsDataBase::class.java, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build()
        }


    }

}