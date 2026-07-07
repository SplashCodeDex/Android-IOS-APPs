package com.dexstudio.core.shareddata.di

import com.dexstudio.core.shareddata.CoreRepository
import com.dexstudio.core.shareddata.db.AppDatabase
import com.dexstudio.core.shareddata.network.NetworkEngine
import com.dexstudio.core.shareddata.network.createHttpClient
import org.koin.dsl.module
import androidx.room.RoomDatabase

val coreModule = module {
    single { createHttpClient() }
    single { NetworkEngine(get()) }
    single { 
        val builder: RoomDatabase.Builder<AppDatabase> = get()
        builder.build()
    }
    single { CoreRepository(get(), get()) }
}
