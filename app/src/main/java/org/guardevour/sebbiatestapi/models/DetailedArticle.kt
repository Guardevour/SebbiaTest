package org.guardevour.sebbiatestapi.models

import kotlinx.serialization.Serializable

@Serializable
data class DetailedArticle(
    val id : Int,
    val title : String,
    val date : String,
    val shortDescription : String,
    val fullDescription : String
)