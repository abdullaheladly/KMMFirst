package com.example.kmmfirst.articles.data

import com.example.kmmfirst.articles.data.ArticlesResponse
import com.example.kmmfirst.articles.domain.ArticleRaw
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ArticlesService(private val httpClient:HttpClient) {
    private val country = "us"
    private val articleCategory = "business"
    private val apiKey = "f819b64314f246cfad9a37bae53689a7"

    suspend fun fetchArticles() : List<ArticleRaw>{
        val response : ArticlesResponse = httpClient.get("https://newsapi.org/v2/top-headlines?country=$country&category=$articleCategory&apiKey=$apiKey").body()
        return response.articles
    }
}