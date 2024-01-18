package com.example.kmmfirst.articles.di

import com.example.kmmfirst.articles.data.ArticlesDataSource
import com.example.kmmfirst.articles.data.ArticlesRepo
import com.example.kmmfirst.articles.data.ArticlesService
import com.example.kmmfirst.articles.domain.ArticlesUseCase
import com.example.kmmfirst.articles.presentation.ArticlesViewModel
import org.koin.dsl.module

val articlesModule = module {
    single<ArticlesService> { ArticlesService(get()) }
    single<ArticlesUseCase> { ArticlesUseCase(get()) }
    single<ArticlesViewModel> { ArticlesViewModel(get()) }
    single<ArticlesDataSource> { ArticlesDataSource(get()) }
    single<ArticlesRepo> { ArticlesRepo(get(), get()) }

}