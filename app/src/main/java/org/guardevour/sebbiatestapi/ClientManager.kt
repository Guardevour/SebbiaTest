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
import org.guardevour.sebbiatestapi.models.DetailedArticle
import org.guardevour.sebbiatestapi.models.DetailedArticleResponse
import org.guardevour.sebbiatestapi.models.ShortArticle
import org.guardevour.sebbiatestapi.models.ShortArticleResponse

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
    suspend fun getAllNewsFromCategory(id: Int, page: Int) : ShortArticleResponse {
        val client = HttpClient()
        return try {
            Json.decodeFromString<ShortArticleResponse>(
                client.get("$BASE_URL/v1/news/categories/$id/news?page=$page").bodyAsText()
            )
        } catch (ex : Exception) {
            ShortArticleResponse(
                code = -1,
                list = listOf<ShortArticle>()
            )
        }
    }
    suspend fun getNewsDetails(id: Int) : DetailedArticleResponse {
        val client = HttpClient()
        return try {
            Json.decodeFromString<DetailedArticleResponse>(
                client.get("$BASE_URL/v1/news/details?id=$id").bodyAsText()
            )
        } catch (ex : Exception) {
            DetailedArticleResponse(
                code = -1,
                news = DetailedArticle(
                    id = 0,
                    date = "",
                    title = "Новость не найдена",
                    fullDescription = "Нам не удалось найти данную новость",
                    shortDescription = "Не найдено"
                )
            )
        }
    }

}