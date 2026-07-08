package com.example

import android.app.Application
import org.koin.core.context.startKoin
import com.dexstudio.core.shareddata.di.coreModule
import com.dexstudio.core.shareddata.di.androidCoreModule
import org.koin.android.ext.koin.androidContext

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules(coreModule, androidCoreModule(this@MyApplication))
        }
    }
}
