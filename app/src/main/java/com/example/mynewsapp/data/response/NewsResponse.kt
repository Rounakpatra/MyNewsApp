package com.example.mynewsapp.data.response

import com.example.mynewsapp.data.model.News

data class NewsResponse(
    val available: Int,
    val news: List<News>,
    val number: Int,
    val offset: Int
)