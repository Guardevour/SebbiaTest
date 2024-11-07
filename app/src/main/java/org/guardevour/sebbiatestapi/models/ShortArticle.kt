package org.guardevour.sebbiatestapi.models

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.serialization.Serializable

@Serializable
data class ShortArticle(
    val id : Int,
    val title : String,
    val date : String,
    val shortDescription : String,
){
    @Composable
    fun Draw(
        modifier: Modifier = Modifier
    ){
        Column(
            modifier = Modifier
                .padding(10.dp)
                .background(
                MaterialTheme.colorScheme.secondary, RoundedCornerShape(10.dp)
            )
                .then(modifier)
        ) {
            Text(text = title)
            Spacer(modifier = Modifier.height(5.dp).fillMaxWidth())
            Text(text = date.split('T')[0])
            Spacer(modifier = Modifier.height(5.dp).fillMaxWidth())
            Text(text = shortDescription)

        }
    }
}