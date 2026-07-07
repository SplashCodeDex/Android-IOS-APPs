package com.dexstudio.core.shareddata.di

import androidx.room3.Room
import androidx.room3.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.dexstudio.core.shareddata.db.AppDatabase
import org.koin.dsl.module
import java.io.File

fun desktopCoreModule() = module {
    single<RoomDatabase.Builder<AppDatabase>> {
        val dbFile = File(System.getProperty("java.io.tmpdir"), "app.db")
        Room.databaseBuilder<AppDatabase>(name = dbFile.absolutePath)
            .setDriver(BundledSQLiteDriver())
    }
}
