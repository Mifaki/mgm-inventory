package com.brawijaya.mgminventory.ui.returnForm.viewmodel

import android.net.Uri
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ReturnFormViewModel : ViewModel() {

    var formState by mutableStateOf(BorrowFormState())
        private set

    fun updateSelectedItem(value: String) {
        formState = formState.copy(selectedItem = value)
    }

    fun updateBorrowDate(value: String) {
        formState = formState.copy(borrowDate = value)
    }

    fun updateReturnDate(value: String) {
        formState = formState.copy(returnDate = value)
    }

    fun updateItemIdImage(value: Uri?) {
        formState = formState.copy(itemIdImage = value)
    }

    fun submitForm() {
        formState = formState.copy(formCompleted = true)
    }
}

data class BorrowFormState(
    val formCompleted: Boolean = false,

    val selectedItem: String = "",
    val borrowDate: String = "",
    val returnDate: String = "",
    val itemIdImage: Uri? = null,
)