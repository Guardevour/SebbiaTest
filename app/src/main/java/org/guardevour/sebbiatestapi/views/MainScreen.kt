package org.guardevour.sebbiatestapi.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun MainScreen(
    modifier: Modifier = Modifier
) {
    Box(modifier = Modifier
        .fillMaxSize()
        .then(modifier)) {
        NewsTopBar(
            modifier = Modifier.align(Alignment.TopCenter)
        )
    }
}