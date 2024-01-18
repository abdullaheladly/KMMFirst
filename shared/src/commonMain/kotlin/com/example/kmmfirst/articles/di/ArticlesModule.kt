package com.example.kmmfirst.articles.di

import com.example.kmmfirst.articles.ArticlesService
import com.example.kmmfirst.articles.ArticlesUseCase
import com.example.kmmfirst.articles.ArticlesViewModel
import org.koin.dsl.module

val  articlesModule = module {
    single<ArticlesService> { ArticlesService(get()) }
    single<ArticlesUseCase> { ArticlesUseCase(get()) }
    single <ArticlesViewModel> { ArticlesViewModel(get()) }

}