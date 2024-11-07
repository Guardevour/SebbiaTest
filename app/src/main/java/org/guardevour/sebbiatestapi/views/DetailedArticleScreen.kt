package org.guardevour.sebbiatestapi.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import org.guardevour.sebbiatestapi.components.HtmlText
import org.guardevour.sebbiatestapi.viewmodels.CategoriesViewModel
import org.guardevour.sebbiatestapi.viewmodels.DetailedArticleViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun DetailedArticleScreen(
    modifier: Modifier = Modifier,
    newsId: Int,
    detailedArticleViewModel: DetailedArticleViewModel = koinViewModel()
) {
    detailedArticleViewModel.getDetailedArticle(newsId)

    detailedArticleViewModel.detailedArticle.value?.let {
        Column(
            modifier = Modifier.fillMaxSize(0.9f)
        ) {
            Text(text = "${it.id} \n" +
                    " ${it.title} \n" +
                    " ${it.date.split('T')[0]} \n" +
                    " ${it.shortDescription} \n")
            HtmlText(html = it.fullDescription)
        }
    }
}