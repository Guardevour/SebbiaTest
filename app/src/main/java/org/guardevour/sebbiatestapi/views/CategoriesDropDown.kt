package org.guardevour.sebbiatestapi.views

import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import org.guardevour.sebbiatestapi.viewmodels.CategoriesDropDownViewModel
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoriesDropDown(
    modifier: Modifier = Modifier,
    isExpanded: MutableState<Boolean>,
    selectedCategoryId: MutableIntState,
    categoriesDropDownViewModel: CategoriesDropDownViewModel = koinViewModel()
) {

    ExposedDropdownMenuBox(
        expanded = isExpanded.value,
        onExpandedChange = { isExpanded.value = !isExpanded.value },
        modifier = Modifier.then(modifier),
    ){

        TextField(
            modifier = Modifier.menuAnchor(),
            readOnly = true,
            value =
            categoriesDropDownViewModel.categoriesStateList.find {
                it.id ==  selectedCategoryId.intValue
            }?.name ?: "" ,
            onValueChange = {},
            label = { Text("Категория:") },
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded.value) },
            colors = ExposedDropdownMenuDefaults.textFieldColors(),
        )


        ExposedDropdownMenu(
            expanded = isExpanded.value,
            onDismissRequest = { isExpanded.value = false },
        ) {
            categoriesDropDownViewModel.categoriesStateList.forEach { selectionOption ->
                DropdownMenuItem(
                    text = { Text(selectionOption.name) },
                    onClick = {
                        selectedCategoryId.intValue = selectionOption.id
                        isExpanded.value = false
                    },
                )
            }
        }
    }
}