package org.guardevour.sebbiatestapi.viewmodels

import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.guardevour.sebbiatestapi.ClientManager
import org.guardevour.sebbiatestapi.models.ShortArticle


class NewsViewModel : ViewModel() {
    val selectedCategoryId =  mutableIntStateOf(-1)

    val selectedPageIndex =  mutableIntStateOf(0)

    private val _news: SnapshotStateList<ShortArticle> = SnapshotStateList()
    val news = _news

    val isLastPage = derivedStateOf { _news.isEmpty() }

     private suspend fun fillNews(){
        if (selectedCategoryId.intValue >= 0) {
            val receivedNews = ClientManager.getAllNewsFromCategory(
                selectedCategoryId.intValue,
                selectedPageIndex.intValue
            ).list
            if (receivedNews != _news.toList()) {
                _news.clear()
                receivedNews.forEach {
                    _news.add(it)
                }
            }
        }

    }
    init {
        startFillNews()
    }
    fun startFillNews(){
        viewModelScope.launch {
            fillNews()
        }
    }
}