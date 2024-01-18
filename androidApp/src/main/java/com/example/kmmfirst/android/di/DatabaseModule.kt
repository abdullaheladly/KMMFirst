package com.example.kmmfirst.android.di

import app.cash.sqldelight.db.SqlDriver
import com.example.kmmfirst.db.DatabaseDriverFactory
import com.example.kmmfirst.db.KMMFirstDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single<SqlDriver> { DatabaseDriverFactory(androidContext()).createDriver() }

    single<KMMFirstDatabase> { KMMFirstDatabase(get()) }
}