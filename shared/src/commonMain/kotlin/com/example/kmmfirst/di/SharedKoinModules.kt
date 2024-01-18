package com.example.kmmfirst.di

import com.example.kmmfirst.articles.di.articlesModule

val sharedKoinModule = listOf(
    articlesModule,
    networkModule
)