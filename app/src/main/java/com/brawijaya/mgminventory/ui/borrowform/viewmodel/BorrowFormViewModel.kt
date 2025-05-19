package com.brawijaya.mgminventory.ui.borrowform.viewmodel

import android.net.Uri
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class BorrowFormViewModel : ViewModel() {

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

    fun submitForm() {
        formState = formState.copy(formCompleted = true)
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