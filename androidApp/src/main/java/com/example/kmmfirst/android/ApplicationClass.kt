package com.example.kmmfirst.android

import android.app.Application
import com.example.kmmfirst.android.di.databaseModule
import com.example.kmmfirst.android.di.viewModelsModule
import com.example.kmmfirst.di.sharedKoinModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ApplicationClass : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        val modules = sharedKoinModule + viewModelsModule + databaseModule
        startKoin {
            androidContext(this@ApplicationClass)
            modules(modules)
        }
    }
}