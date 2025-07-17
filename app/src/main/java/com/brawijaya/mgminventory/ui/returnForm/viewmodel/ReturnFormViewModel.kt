package com.brawijaya.mgminventory.ui.returnForm.viewmodel

import android.content.Context
import android.net.Uri
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.brawijaya.mgminventory.data.service.borrow.dto.AddReturnItemRequest
import com.brawijaya.mgminventory.data.service.borrow.dto.AddReturnItemResponse
import com.brawijaya.mgminventory.domain.usecase.borrow.AddReturnItemUseCase
import com.brawijaya.mgminventory.utlis.helper.uriToFile
import com.brawijaya.mgminventory.utlis.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ReturnFormViewModel @Inject constructor(
    private val _addReturnItem: AddReturnItemUseCase
) : ViewModel() {

    var formState by mutableStateOf(BorrowFormState())
        private set

    fun updateItemId(value: String) {
        formState = formState.copy(itemId = value)
    }

    fun updateBorrowDate(value: String) {
        formState = formState.copy(borrowDate = value)
    }

    fun updateReturnDate(value: String) {
        formState = formState.copy(returnDate = value)
    }

    fun updateItemIdImage(value: Uri?) {
        formState = formState.copy(damagedItem = value)
    }

    private val _returnSubmitResult =
        MutableStateFlow<Resource<AddReturnItemResponse>>(Resource.Idle)
    val returnSubmitResult: MutableStateFlow<Resource<AddReturnItemResponse>> = _returnSubmitResult

    fun submitReturn(context: Context) {
        viewModelScope.launch {
            Log.d("ReturnFormViewModel", "submitReturn: $formState")
            _returnSubmitResult.value = Resource.Loading

            val damageFile = formState.damagedItem?.let { uri ->
                uriToFile(context, uri)
            }

            if (damageFile == null) {
                _returnSubmitResult.value = Resource.Error("Gagal mengakses file foto kerusakan.")
                return@launch
            }

            val request = AddReturnItemRequest(
                itemId = formState.itemId,
                borrowDate = formState.borrowDate,
                returnDate = formState.returnDate,
                damagedItem = damageFile
            )

            _addReturnItem(request).collect() {
                _returnSubmitResult.value = it
            }
        }
    }
}

data class BorrowFormState(
    val itemId: String = "",
    val borrowDate: String = "",
    val returnDate: String = "",
    val damagedItem: Uri? = null,
)