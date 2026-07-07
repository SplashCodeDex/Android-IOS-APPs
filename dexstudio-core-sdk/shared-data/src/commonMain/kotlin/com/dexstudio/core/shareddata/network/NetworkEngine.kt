package com.dexstudio.core.shareddata.network

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText

class NetworkEngine(private val httpClient: HttpClient) {
    suspend fun fetchSampleData(): String {
        return try {
            val response = httpClient.get("https://jsonplaceholder.typicode.com/posts/1")
            response.bodyAsText()
        } catch (e: Exception) {
            "Error fetching data: ${e.message}"
        }
    }
}

fun createHttpClient(): HttpClient {
    return HttpClient {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                prettyPrint = true
            })
        }
    }
}
