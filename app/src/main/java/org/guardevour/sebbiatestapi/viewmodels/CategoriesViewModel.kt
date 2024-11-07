package org.guardevour.sebbiatestapi.viewmodels

import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.guardevour.sebbiatestapi.ClientManager
import org.guardevour.sebbiatestapi.models.Category

class CategoriesViewModel : ViewModel() {

    private val _categoriesStateList: SnapshotStateList<Category> = SnapshotStateList()
    val categoriesStateList = _categoriesStateList
    private suspend fun fillCategoriesList(){
        val receivedCategories = ClientManager.getAllCategories().list
        if (receivedCategories != _categoriesStateList.toList()){
            _categoriesStateList.clear()
            receivedCategories.forEach {
                _categoriesStateList.add(it)
            }
        }
    }

    init {
        viewModelScope.launch{
            fillCategoriesList()
        }
    }
}