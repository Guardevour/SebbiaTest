package org.guardevour.sebbiatestapi

import android.net.http.NetworkException
import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import io.ktor.http.Headers
import io.ktor.http.HttpHeaders
import io.ktor.http.headers
import kotlinx.coroutines.delay
import kotlinx.serialization.json.Json
import org.guardevour.sebbiatestapi.models.Category
import org.guardevour.sebbiatestapi.models.CategoryResponse

object ClientManager {
    private const val BASE_URL = "http://testtask.sebbia.com"

    suspend fun getAllCategories() : CategoryResponse {
        val client = HttpClient()
        return try {
            Json.decodeFromString<CategoryResponse>(
                client.get("$BASE_URL/v1/news/categories").bodyAsText()
            )
        } catch (ex : Exception) {
            CategoryResponse(
                code = -1,
                list = listOf<Category>()
            )
        }
    }

}