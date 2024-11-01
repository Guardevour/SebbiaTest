package org.guardevour.sebbiatestapi.models

import kotlinx.serialization.Serializable

@Serializable
data class ShortArticle(
    val id : Int,
    val title : String,
    val date : String,
    val shortDescription : String,
)