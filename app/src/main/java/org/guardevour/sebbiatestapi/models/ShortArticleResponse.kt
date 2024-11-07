package org.guardevour.sebbiatestapi.models

import kotlinx.serialization.Serializable

@Serializable
data class ShortArticleResponse(
    val code: Int,
    val list: List<ShortArticle>
)