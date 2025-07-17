package com.brawijaya.mgminventory.ui.returnForm

import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.brawijaya.mgminventory.ui.returnForm.components.ReturnForm
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.brawijaya.mgminventory.ui.components.MGMScaffold
import com.brawijaya.mgminventory.ui.navigation.Screen
import com.brawijaya.mgminventory.ui.returnForm.viewmodel.ReturnFormViewModel
import com.brawijaya.mgminventory.utlis.Resource
import com.brawijaya.mgminventory.utlis.helper.formatIsoToDMY

@Composable
fun ReturnFormScreen(
    navController: NavHostController,
    viewModel: ReturnFormViewModel = hiltViewModel(),
    id: String,
    name: String,
    borrowDate: String,
    returnDate: String
) {
    val context = LocalContext.current
    val formState = viewModel.formState
    val imagePickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        viewModel.updateItemIdImage(uri)
    }

    LaunchedEffect(Unit) {
        viewModel.updateBorrowDate(borrowDate.formatIsoToDMY())
        viewModel.updateReturnDate(returnDate.formatIsoToDMY())
        viewModel.updateItemId(id)
    }

    val returnResult by viewModel.returnSubmitResult.collectAsState()

    LaunchedEffect(returnResult) {
        when (returnResult) {
            is Resource.Error -> {
                Toast.makeText(context, (returnResult as Resource.Error).message, Toast.LENGTH_SHORT).show()
            }
            is Resource.Success -> {
                Toast.makeText(context, "Pengembalian berhasil!", Toast.LENGTH_SHORT).show()
                navController.popBackStack()
            }
            else -> {}
        }
    }


    MGMScaffold(
        title = "Form Pengembalian",
        showBackButton = true,
        navController = navController
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                "Detail Pengembalian",
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.SemiBold
            )

            Column {
                Text(
                    text = "Nama Barang",
                    style = MaterialTheme.typography.bodyMedium
                )
                OutlinedTextField(
                    value = name,
                    onValueChange = {},
                    modifier = Modifier.fillMaxWidth().height(60.dp).padding(top = 8.dp),
                    textStyle = TextStyle(fontSize = 14.sp),
                    singleLine = true,
                    shape = RoundedCornerShape(8.dp),
                    readOnly = true,
                )
            }

            Column {
                Text(
                    text = "Tanggal Peminjaman",
                    style = MaterialTheme.typography.bodyMedium
                )
                OutlinedTextField(
                    value = borrowDate.formatIsoToDMY(),
                    onValueChange = {},
                    modifier = Modifier.fillMaxWidth().height(60.dp).padding(top = 8.dp),
                    textStyle = TextStyle(fontSize = 14.sp),
                    singleLine = true,
                    shape = RoundedCornerShape(8.dp),
                    readOnly = true,
                )
            }

            Column {
                Text(
                    text = "Tanggal Pengembalian",
                    style = MaterialTheme.typography.bodyMedium
                )
                OutlinedTextField(
                    value = returnDate.formatIsoToDMY(),
                    onValueChange = {},
                    modifier = Modifier.fillMaxWidth().height(60.dp).padding(top = 8.dp),
                    textStyle = TextStyle(fontSize = 14.sp),
                    singleLine = true,
                    shape = RoundedCornerShape(8.dp),
                    readOnly = true,
                )
            }

            Column {
                Text(
                    text = "Foto Kerusakan",
                    style = MaterialTheme.typography.bodyMedium
                )

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(160.dp)
                        .padding(top = 8.dp)
                        .border(
                            width = 1.dp,
                            color = Color.Gray,
                            shape = RoundedCornerShape(8.dp)
                        )
                        .clip(RoundedCornerShape(8.dp))
                ) {
                    if (formState.damagedItem != null) {
                        Box(modifier = Modifier.fillMaxSize()) {
                            Image(
                                painter = rememberAsyncImagePainter(
                                    ImageRequest.Builder(context)
                                        .data(data = formState.damagedItem)
                                        .build()
                                ),
                                contentDescription = "Student ID Image",
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Fit
                            )

                            Surface(
                                modifier = Modifier
                                    .align(Alignment.TopEnd)
                                    .padding(8.dp)
                                    .size(28.dp),
                                shape = CircleShape,
                                color = MaterialTheme.colorScheme.primary
                            ) {
                                IconButton(
                                    onClick = { viewModel.updateItemIdImage(null) },
                                    modifier = Modifier.size(28.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Close,
                                        contentDescription = "Remove Image",
                                        tint = MaterialTheme.colorScheme.error,
                                        modifier = Modifier.size(16.dp)
                                    )
                                }
                            }
                        }
                    } else {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .clickable { imagePickerLauncher.launch("image/*") },
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.Add,
                                contentDescription = "Upload Student ID",
                                tint = MaterialTheme.colorScheme.primary,
                                modifier = Modifier.size(36.dp)
                            )
                        }
                    }
                }
            }

            Button(
                onClick = {
                    viewModel.submitReturn(context)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    disabledContainerColor = Color.Gray
                ),
            ) {
                Text("Kembalikan")
            }
        }
    }
}