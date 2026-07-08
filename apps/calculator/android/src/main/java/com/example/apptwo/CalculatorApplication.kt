package com.example.apptwo

import android.app.Application
import org.koin.core.context.startKoin
import com.dexstudio.core.shareddata.di.coreModule
import com.dexstudio.core.shareddata.di.androidCoreModule
import org.koin.android.ext.koin.androidContext

class CalculatorApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@CalculatorApplication)
            modules(coreModule, androidCoreModule(this@CalculatorApplication), com.example.apptwo.di.appModule)
        }
    }
}
