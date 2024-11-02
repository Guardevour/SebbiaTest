package org.guardevour.sebbiatestapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import org.guardevour.sebbiatestapi.ui.theme.SebbiaTestAPITheme
import org.guardevour.sebbiatestapi.views.MainScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SebbiaTestAPITheme {
                MainScreen()
            }
        }
    }
}
