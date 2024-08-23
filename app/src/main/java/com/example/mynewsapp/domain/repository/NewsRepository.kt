package com.example.mynewsapp.domain.repository

import com.example.mynewsapp.data.response.NewsResponse
import retrofit2.Response

interface NewsRepository {

    suspend fun getNews(
        language: String,
        text: String?,
        country: String?

    ):Response<NewsResponse>

}