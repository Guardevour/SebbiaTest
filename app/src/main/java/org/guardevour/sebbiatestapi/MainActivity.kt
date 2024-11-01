package org.guardevour.sebbiatestapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.launch
import org.guardevour.sebbiatestapi.models.Category
import org.guardevour.sebbiatestapi.ui.theme.SebbiaTestAPITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SebbiaTestAPITheme {
                val scope = rememberCoroutineScope()
                val categories = remember{
                    mutableStateListOf<Category>()
                }
                SideEffect {
                    scope.launch {
                        val receivedCategories = ClientManager.getAllCategories().list
                        if (receivedCategories != categories.toList()){
                            receivedCategories.forEach {
                                categories.add(it)
                            }
                        }
                    }

                }
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    if (categories.isNotEmpty()) {
                        LazyColumn {
                            items(categories.size) {
                                Text(text = categories[it].name)
                            }
                        }
                    }
                }
            }
        }
    }
}
