package org.guardevour.sebbiatestapi.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun Screen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier.fillMaxSize().then(modifier)
    ) {

    }
}