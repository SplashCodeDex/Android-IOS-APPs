package com.dexstudio.core.shareddata.di

import android.content.Context
import androidx.room3.Room
import androidx.room3.RoomDatabase
import com.dexstudio.core.shareddata.db.AppDatabase
import org.koin.dsl.module

fun androidCoreModule(context: Context) = module {
    single<RoomDatabase.Builder<AppDatabase>> {
        val dbFile = context.getDatabasePath("app.db")
        Room.databaseBuilder<AppDatabase>(
            context = context.applicationContext,
            name = dbFile.absolutePath
        )
    }
}
