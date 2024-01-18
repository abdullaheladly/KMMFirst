package com.example.kmmfirst.db

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver

actual class DatabaseDriverFactory {
    actual fun createDriver(): SqlDriver =
        NativeSqliteDriver(
            schema = KMMFirstDatabase.Schema,
            name = "KMMDatabase.db"
        )
}