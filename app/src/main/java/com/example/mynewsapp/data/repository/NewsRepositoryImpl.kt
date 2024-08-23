package com.example.mynewsapp.data.repository

import com.example.mynewsapp.data.response.NewsResponse
import com.example.mynewsapp.data.web.NewsApi
import com.example.mynewsapp.domain.repository.NewsRepository
import retrofit2.Response
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(val api:NewsApi) :NewsRepository {
    override suspend fun getNews(
        language: String,
        text: String?,
        country: String?
    ): Response<NewsResponse> {
        return api.getNews(country,language,text)
    }


}