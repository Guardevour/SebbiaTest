package org.guardevour.sebbiatestapi.models

import kotlinx.serialization.Serializable

@Serializable
data class CategoryResponse(
    val code : Int,
    val list: List<Category>
) {
}