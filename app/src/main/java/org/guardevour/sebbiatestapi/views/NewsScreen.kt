package org.guardevour.sebbiatestapi.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import org.guardevour.sebbiatestapi.Routes
import org.guardevour.sebbiatestapi.viewmodels.NewsViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun NewsScreen(
    modifier: Modifier = Modifier,
    categoryId: Int,
    navHostController: NavHostController,
    newsViewModel: NewsViewModel = koinViewModel()
) {
    newsViewModel.selectedCategoryId.intValue = categoryId
    newsViewModel.startFillNews()

    Box(modifier = Modifier
        .fillMaxSize()
        .then(modifier)) {

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
                    .fillMaxHeight(0.8f)
                    .fillMaxWidth()
                    .align(Alignment.Center)
                    .then(modifier)
            ) {
                items(newsViewModel.news.size) {
                    newsViewModel.news[it].Draw(modifier = Modifier.clickable {
                        navHostController.navigate("${Routes.NEWS}/${newsViewModel.news[it].id}")
                    })
                }
            }

        Row(
            modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            horizontalArrangement = Arrangement.Center
        ) {
            IconButton(onClick = {
                if (newsViewModel.selectedPageIndex.intValue > 0) {
                    newsViewModel.selectedPageIndex.intValue--
                    newsViewModel.startFillNews()
                }
            } ) {
                Icon(Icons.Outlined.ArrowBack, "ArrowBack")
            }

            Text(text = newsViewModel.selectedPageIndex.intValue.toString())

            IconButton(onClick = {
                if (!newsViewModel.isLastPage.value) {
                    newsViewModel.selectedPageIndex.intValue++
                    newsViewModel.startFillNews()
                }

            }) {
                Icon(Icons.Outlined.ArrowForward, "ArrowForward")
            }
        }
    }
}