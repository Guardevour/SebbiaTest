package org.guardevour.sebbiatestapi.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

@Composable
fun NewsTopBar(modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier.fillMaxWidth().background(MaterialTheme.colorScheme.primary).then(modifier)
    ) {
        val isExpanded = remember{
            mutableStateOf(false)
        }
        val selectedCategoryId = remember {
            mutableIntStateOf(-1)
        }

        CategoriesDropDown(isExpanded = isExpanded, selectedCategoryId = selectedCategoryId)

    }
}