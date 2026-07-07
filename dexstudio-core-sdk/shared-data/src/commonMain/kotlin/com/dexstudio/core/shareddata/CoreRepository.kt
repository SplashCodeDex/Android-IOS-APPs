package com.dexstudio.core.shareddata

import com.dexstudio.core.shareddata.db.AppDatabase
import com.dexstudio.core.shareddata.network.NetworkEngine

class CoreRepository(
    private val networkEngine: NetworkEngine,
    private val database: AppDatabase
) {
    suspend fun getAppConfig(): String {
        // Just demonstrating that Ktor works.
        val remoteData = networkEngine.fetchSampleData()
        return "DeXStudio Core Stack v2.1.0 (KMP)\n$remoteData"
    }
}
