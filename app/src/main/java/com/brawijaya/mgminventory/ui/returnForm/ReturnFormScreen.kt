package com.brawijaya.mgminventory.ui.returnForm

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.brawijaya.mgminventory.ui.returnForm.components.ReturnForm
import androidx.navigation.NavHostController
import com.brawijaya.mgminventory.ui.components.MGMScaffold
import com.brawijaya.mgminventory.ui.returnForm.viewmodel.ReturnFormViewModel

@Composable
fun ReturnFormScreen(
    navController: NavHostController,
    viewModel: ReturnFormViewModel = viewModel()
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
                    "return" -> viewModel.updateReturnDate(selectedDate)
                }

                handle.remove<String>("selected_date")
                handle.remove<String>("date_type")
            }
        }
    }

    val formCompleted = formState.selectedItem.isNotBlank() &&
            formState.borrowDate.isNotBlank() &&
            formState.returnDate.isNotBlank() &&
            formState.itemIdImage != null


    MGMScaffold(
        title = "Form Pengembalian",
        showBackButton = true,
        navController = navController,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            ReturnForm(
                navController = navController,
                selectedItem = formState.selectedItem,
                onSelectedItemChange = { viewModel.updateSelectedItem(it) },
                borrowDate = formState.borrowDate,
                onBorrowDateChange = { viewModel.updateBorrowDate(it) },
                returnDate = formState.returnDate,
                onReturnDateChange = { viewModel.updateReturnDate(it) },
                itemIdImage = formState.itemIdImage,
                onItemIdImageChange = { viewModel.updateItemIdImage(it) }
            )

            Button(
                onClick = { viewModel.submitForm() },
                modifier = Modifier.fillMaxWidth(),
                enabled = formCompleted,
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

    if (formState.formCompleted) {
        // TODO: IMPLEMENT SUBMIT LOGIC
        LaunchedEffect(Unit) {
            navController.popBackStack()
        }
    }
}