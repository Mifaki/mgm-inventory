package com.brawijaya.mgminventory.ui.borrowform.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.brawijaya.mgminventory.ui.navigation.Screen

@Composable
fun BorrowingDetailsForm(
    navController: NavHostController,
    selectedItem: String,
    onSelectedItemChange: (String) -> Unit,
    borrowReason: String,
    onBorrowReasonChange: (String) -> Unit,
    borrowDate: String,
    onBorrowDateChange: (String) -> Unit,
    pickupDate: String,
    onPickupDateChange: (String) -> Unit,
    returnDate: String,
    onReturnDateChange: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    val items = listOf("Laptop", "Proyektor", "Kamera", "Mikrofon", "Tripod")

    Column(
        modifier = Modifier.fillMaxWidth().padding(top = 24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Mau Pinjam Apa?",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold,
        )

        Column(
            modifier = Modifier.padding(top = 12.dp),
        ) {
            Text(
                text = "Alat yang dipinjam",
                style = MaterialTheme.typography.bodyMedium
            )

            Box(
                modifier = Modifier.padding(top = 8.dp)
            ) {
                OutlinedTextField(
                    value = selectedItem,
                    onValueChange = {},
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(52.dp),
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = "Select Equipment",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    },
                    textStyle = TextStyle(fontSize = 14.sp),
                    readOnly = true,
                    shape = RoundedCornerShape(8.dp),
                )

                Box(
                    modifier = Modifier
                        .matchParentSize()
                        .clickable { expanded = true }
                )

                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    items.forEach { item ->
                        DropdownMenuItem(
                            text = { Text(item) },
                            onClick = {
                                onSelectedItemChange(item)
                                expanded = false
                            }
                        )
                    }
                }
            }
        }

        Column {
            Text(
                text = "Alasan Peminjaman",
                style = MaterialTheme.typography.bodyMedium
            )
            OutlinedTextField(
                value = borrowReason,
                onValueChange = onBorrowReasonChange,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .padding(top = 8.dp),
                textStyle = TextStyle(fontSize = 14.sp),
                minLines = 3,
                shape = RoundedCornerShape(8.dp)
            )
        }

        Column {
            Text(
                text = "Tanggal Peminjaman",
                style = MaterialTheme.typography.bodyMedium
            )
            OutlinedTextField(
                value = borrowDate,
                onValueChange = onBorrowDateChange,
                modifier = Modifier.fillMaxWidth().height(60.dp).padding(top = 8.dp),
                textStyle = TextStyle(fontSize = 14.sp),
                singleLine = true,
                shape = RoundedCornerShape(8.dp),
                readOnly = true,
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.DateRange,
                        contentDescription = "Select Date",
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.clickable {
                            navController.navigate(
                                Screen.Calendar.createRoute(
                                    title = "Pilih Tanggal Peminjaman",
                                    dateType = "borrow"
                                )
                            )
                        }
                    )
                }
            )
        }

        Column {
            Text(
                text = "Tanggal Pengambilan Alat",
                style = MaterialTheme.typography.bodyMedium
            )
            OutlinedTextField(
                value = pickupDate,
                onValueChange = onPickupDateChange,
                modifier = Modifier.fillMaxWidth().height(60.dp).padding(top = 8.dp),
                textStyle = TextStyle(fontSize = 14.sp),
                singleLine = true,
                shape = RoundedCornerShape(8.dp),
                readOnly = true,
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.DateRange,
                        contentDescription = "Select Date",
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.clickable {
                            navController.navigate(
                                Screen.Calendar.createRoute(
                                    title = "Pilih Tanggal Pengambilan Alat",
                                    dateType = "pickup"
                                )
                            )
                        }
                    )
                }
            )
        }

        Column {
            Text(
                text = "Tanggal Pengembalian",
                style = MaterialTheme.typography.bodyMedium
            )
            OutlinedTextField(
                value = returnDate,
                onValueChange = onReturnDateChange,
                modifier = Modifier.fillMaxWidth().height(60.dp).padding(top = 8.dp),
                textStyle = TextStyle(fontSize = 14.sp),
                singleLine = true,
                shape = RoundedCornerShape(8.dp),
                readOnly = true,
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.DateRange,
                        contentDescription = "Select Date",
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.clickable {
                            navController.navigate(
                                Screen.Calendar.createRoute(
                                    title = "Pilih Tanggal Pengembalian",
                                    dateType = "return"
                                )
                            )
                        }
                    )
                }
            )
        }
    }
}