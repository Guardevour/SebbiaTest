package org.guardevour.sebbiatestapi.views

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import org.guardevour.sebbiatestapi.Routes
import org.guardevour.sebbiatestapi.viewmodels.CategoriesViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun CategoriesScreen(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
    categoriesViewModel: CategoriesViewModel = koinViewModel()
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxHeight(0.8f)
            .fillMaxWidth()
            .then(modifier),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(categoriesViewModel.categoriesStateList.size){ index: Int ->
            Text(
                text = categoriesViewModel.categoriesStateList[index].name,
                modifier = Modifier
                    .padding(10.dp)
                    .height(40.dp)
                    .fillMaxWidth(0.9f)
                    .clickable {
                        navHostController
                            .navigate("${Routes.CATEGORIES.text}/" +
                                    "${categoriesViewModel.categoriesStateList[index].id}")
                    }
                    .background(MaterialTheme.colorScheme.primary, RoundedCornerShape(10.dp)),
                textAlign = TextAlign.Center

            )
        }
    }
}