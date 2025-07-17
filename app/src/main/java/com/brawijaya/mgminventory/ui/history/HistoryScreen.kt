package com.brawijaya.mgminventory.ui.history

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.brawijaya.mgminventory.R
import com.brawijaya.mgminventory.domain.model.borrow.BorrowItem
import com.brawijaya.mgminventory.ui.components.MGMScaffold
import com.brawijaya.mgminventory.ui.history.components.HistoryCard
import com.brawijaya.mgminventory.ui.history.viewModel.HistoryViewModel
import com.brawijaya.mgminventory.ui.itemreturn.components.ItemReturnSteps
import com.brawijaya.mgminventory.ui.navigation.Screen
import com.brawijaya.mgminventory.utlis.Resource
import com.brawijaya.mgminventory.utlis.helper.formatIsoToDMY

@Composable
fun HistoryScreen(
    navController: NavHostController,
    viewModel: HistoryViewModel = hiltViewModel()
) {
    LaunchedEffect(Unit) {
        viewModel.getItems()
    }

    val borrowHistoryList by viewModel.itemsState.collectAsState()

    MGMScaffold(
        title = "Riwayat",
        showBackButton = true,
        navController = navController
    ) {
        Spacer(Modifier.padding(top = 16.dp))

        when (borrowHistoryList) {
            is Resource.Loading -> {
                CircularProgressIndicator()
            }

            is Resource.Success -> {
                ShowList(
                    borrowHistoryList = (borrowHistoryList as Resource.Success<List<BorrowItem>>).data,
                    navController = navController
                )
            }

            is Resource.Error -> {
                val message = (borrowHistoryList as Resource.Error).message
                Log.e("HistoryScreen", "Error: $message")
            }

            else -> {}
        }
    }
}

@Composable
fun ShowList(
    borrowHistoryList: List<BorrowItem>,
    navController: NavHostController
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(borrowHistoryList.count()) { index ->
            val history = borrowHistoryList[index]
            HistoryCard(
                itemName = history.itemName,
                borrowDate = history.borrowDate,
                returnDate = history.returnDate,
                status = history.status,
                onReturnClick = {
                    navController.navigate(Screen.ReturnForm.createRoute(
                        id = history.id,
                        name = history.itemName,
                        borrowDate = history.borrowDate,
                        returnDate = history.returnDate
                    ))
                }
            )
        }
    }
}