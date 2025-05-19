package com.brawijaya.mgminventory.ui.borrowform

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.brawijaya.mgminventory.ui.borrowform.components.BorrowingDetailsForm
import com.brawijaya.mgminventory.ui.borrowform.components.PersonalDataForm
import com.brawijaya.mgminventory.ui.borrowform.viewmodel.BorrowFormViewModel
import com.brawijaya.mgminventory.ui.components.MGMScaffold

@Composable
fun BorrowFormScreen(
    navController: NavHostController,
    viewModel: BorrowFormViewModel = viewModel()
) {
    val formState = viewModel.formState

    val currentBackStackEntry = navController.currentBackStackEntry
    val savedStateHandle = currentBackStackEntry?.savedStateHandle

    LaunchedEffect(savedStateHandle) {
        savedStateHandle?.let { handle ->
            val selectedDate = handle.get<String>("selected_date")
            val dateType = handle.get<String>("date_type")

            if (selectedDate != null && dateType != null) {
                when (dateType) {
                    "borrow" -> viewModel.updateBorrowDate(selectedDate)
                    "pickup" -> viewModel.updatePickupDate(selectedDate)
                    "return" -> viewModel.updateReturnDate(selectedDate)
                }

                handle.remove<String>("selected_date")
                handle.remove<String>("date_type")
            }
        }
    }

    val firstStepComplete = formState.fullName.isNotBlank() &&
            formState.nim.isNotBlank() &&
            formState.studyProgram.isNotBlank() &&
            formState.studentEmail.isNotBlank() &&
            formState.studentIdImage != null

    val secondStepComplete = formState.selectedItem.isNotBlank() &&
            formState.borrowReason.isNotBlank() &&
            formState.borrowDate.isNotBlank() &&
            formState.pickupDate.isNotBlank() &&
            formState.returnDate.isNotBlank()

    MGMScaffold(
        title = "Form Peminjaman",
        showBackButton = true,
        navController = navController,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            when (formState.currentStep) {
                1 -> PersonalDataForm(
                    fullName = formState.fullName,
                    onFullNameChange = { viewModel.updateFullName(it) },
                    nim = formState.nim,
                    onNimChange = { viewModel.updateNim(it) },
                    studyProgram = formState.studyProgram,
                    onStudyProgramChange = { viewModel.updateStudyProgram(it) },
                    studentEmail = formState.studentEmail,
                    onStudentEmailChange = { viewModel.updateStudentEmail(it) },
                    studentIdImage = formState.studentIdImage,
                    onStudentIdImageChange = { viewModel.updateStudentIdImage(it) }
                )

                2 -> BorrowingDetailsForm(
                    navController = navController,
                    selectedItem = formState.selectedItem,
                    onSelectedItemChange = { viewModel.updateSelectedItem(it) },
                    borrowReason = formState.borrowReason,
                    onBorrowReasonChange = { viewModel.updateBorrowReason(it) },
                    borrowDate = formState.borrowDate,
                    onBorrowDateChange = { viewModel.updateBorrowDate(it) },
                    pickupDate = formState.pickupDate,
                    onPickupDateChange = { viewModel.updatePickupDate(it) },
                    returnDate = formState.returnDate,
                    onReturnDateChange = { viewModel.updateReturnDate(it) }
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            if (formState.currentStep == 1) {
                Button(
                    onClick = { viewModel.moveToNextStep() },
                    modifier = Modifier.fillMaxWidth(),
                    enabled = firstStepComplete,
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        disabledContainerColor = Color.Gray
                    )
                ) {
                    Text("Simpan & Lanjut", modifier = Modifier.padding(vertical = 8.dp))
                }
            } else {
                Button(
                    onClick = { viewModel.submitForm() },
                    modifier = Modifier.fillMaxWidth(),
                    enabled = secondStepComplete,
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        disabledContainerColor = Color.Gray
                    )
                ) {
                    Text("Ajukan Peminjaman", modifier = Modifier.padding(vertical = 8.dp))
                }
            }
        }
    }

    if (formState.formCompleted) {
        // TODO: IMPLEMENT SUBMIT LOGIC
        LaunchedEffect(Unit) {
            navController.popBackStack()
        }
    }
}