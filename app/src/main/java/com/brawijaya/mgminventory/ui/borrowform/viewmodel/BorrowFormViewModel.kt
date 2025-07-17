package com.brawijaya.mgminventory.ui.borrowform.viewmodel

import android.content.Context
import android.net.Uri
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.brawijaya.mgminventory.data.service.borrow.dto.AddBorrowRequest
import com.brawijaya.mgminventory.data.service.borrow.dto.AddBorrowResponse
import com.brawijaya.mgminventory.domain.model.borrow.LabItem
import com.brawijaya.mgminventory.domain.usecase.borrow.AddBorrowUseCase
import com.brawijaya.mgminventory.domain.usecase.borrow.GetItemToBorrowUseCase
import com.brawijaya.mgminventory.utlis.Resource
import com.brawijaya.mgminventory.utlis.helper.uriToFile
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BorrowFormViewModel @Inject constructor(
    private val _getItemsUseCase: GetItemToBorrowUseCase,
    private val _addBorrowUseCase: AddBorrowUseCase
) : ViewModel() {

    var formState by mutableStateOf(BorrowFormState())
        private set

    fun updateFullName(value: String) {
        formState = formState.copy(fullName = value)
    }

    fun updateNim(value: String) {
        formState = formState.copy(nim = value)
    }

    fun updateStudyProgram(value: String) {
        formState = formState.copy(studyProgram = value)
    }

    fun updateStudentEmail(value: String) {
        formState = formState.copy(studentEmail = value)
    }

    fun updateStudentIdImage(value: Uri?) {
        formState = formState.copy(studentIdImage = value)
    }

    fun updateSelectedItem(value: String) {
        formState = formState.copy(selectedItem = value)
    }

    fun updateBorrowReason(value: String) {
        formState = formState.copy(borrowReason = value)
    }

    fun updateBorrowDate(value: String) {
        formState = formState.copy(borrowDate = value)
    }

    fun updatePickupDate(value: String) {
        formState = formState.copy(pickupDate = value)
    }

    fun updateReturnDate(value: String) {
        formState = formState.copy(returnDate = value)
    }

    fun moveToNextStep() {
        formState = formState.copy(currentStep = 2)
    }

//    fun submitForm() {
//        formState = formState.copy(formCompleted = true)
//    }

    private val _labItems = MutableStateFlow<Resource<List<LabItem>>>(Resource.Idle)
    val labItems: StateFlow<Resource<List<LabItem>>> = _labItems

    fun getLabItems() {
        viewModelScope.launch {
            _getItemsUseCase().collect() {
                _labItems.value = it
            }
        }
    }

    private val _borrowSubmitResult = MutableStateFlow<Resource<AddBorrowResponse>>(Resource.Idle)
    val borrowSubmitResult: StateFlow<Resource<AddBorrowResponse>> = _borrowSubmitResult

    fun submitForm(context: Context) {
        viewModelScope.launch {
            _borrowSubmitResult.value = Resource.Loading

            val ktmFile = formState.studentIdImage?.let { uri ->
                uriToFile(context, uri)
            }

            if (ktmFile == null) {
                _borrowSubmitResult.value = Resource.Error("Gagal mengakses file KTM.")
                return@launch
            }

            val request = AddBorrowRequest(
                itemId = formState.selectedItem,
                userName = formState.fullName,
                userEmail = formState.studentEmail,
                userNIM = formState.nim,
                userProgramStudy = formState.studyProgram,
                reason = formState.borrowReason,
                borrowDate = formState.borrowDate,
                pickupDate = formState.pickupDate,
                returnDate = formState.returnDate,
                userKTM = ktmFile
            )

            _addBorrowUseCase(
                request
            ).collect() {
                _borrowSubmitResult.value = it
            }
        }
    }

}

data class BorrowFormState(
    val currentStep: Int = 1,
    val formCompleted: Boolean = false,

    val fullName: String = "",
    val nim: String = "",
    val studyProgram: String = "",
    val studentEmail: String = "",
    val studentIdImage: Uri? = null,

    val selectedItem: String = "",
    val borrowReason: String = "",
    val borrowDate: String = "",
    val pickupDate: String = "",
    val returnDate: String = ""
)