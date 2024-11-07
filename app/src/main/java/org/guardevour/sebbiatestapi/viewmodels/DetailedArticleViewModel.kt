package org.guardevour.sebbiatestapi.viewmodels

import android.view.View
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.guardevour.sebbiatestapi.ClientManager
import org.guardevour.sebbiatestapi.models.DetailedArticle

class DetailedArticleViewModel : ViewModel() {
    private val _detailedArticle: MutableState<DetailedArticle?> = mutableStateOf(null)
    val detailedArticle = _detailedArticle

    fun getDetailedArticle(id: Int){
        viewModelScope.launch {
            _detailedArticle.value = ClientManager.getNewsDetails(id).news
        }
    }

}