package org.guardevour.sebbiatestapi.models

import kotlinx.serialization.Serializable

@Serializable
data class Category(
    val id: Int,
    val name: String
)