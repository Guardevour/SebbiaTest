package org.guardevour.sebbiatestapi.models

import kotlinx.serialization.Serializable

@Serializable
data class DetailedArticleResponse(
    val code: Int,
    val news: DetailedArticle
)