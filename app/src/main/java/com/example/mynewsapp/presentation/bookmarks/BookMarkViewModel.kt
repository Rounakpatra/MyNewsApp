package com.example.mynewsapp.presentation.bookmarks

import androidx.lifecycle.ViewModel

import com.example.mynewsapp.data.database.NewsDataBase

import dagger.hilt.android.lifecycle.HiltViewModel

import javax.inject.Inject

@HiltViewModel
class BookMarkViewModel @Inject constructor(dataBase: NewsDataBase) : ViewModel() {

    private val newsDao = dataBase.newsDao()

    fun getBookMarks() = newsDao.getNews()


}