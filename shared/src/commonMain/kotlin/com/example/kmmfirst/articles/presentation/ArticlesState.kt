package com.example.kmmfirst.articles.presentation

import com.example.kmmfirst.articles.domain.Article

data class ArticlesState (
    val articles:List<Article> = listOf(),
    val loading:Boolean = false,
    val error:String? = null,
    )
