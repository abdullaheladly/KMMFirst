package com.example.kmmfirst.di

import app.cash.sqldelight.db.SqlDriver
import com.example.kmmfirst.db.DatabaseDriverFactory
import com.example.kmmfirst.db.KMMFirstDatabase
import org.koin.dsl.module

val databaseModule = module {
    single <SqlDriver> { DatabaseDriverFactory().createDriver() }
    single <KMMFirstDatabase> { KMMFirstDatabase(get()) }
}