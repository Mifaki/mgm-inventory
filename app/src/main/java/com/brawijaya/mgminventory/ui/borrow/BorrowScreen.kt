package com.brawijaya.mgminventory.ui.borrow

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.brawijaya.mgminventory.R
import com.brawijaya.mgminventory.ui.borrow.components.BorrowSteps
import com.brawijaya.mgminventory.ui.components.MGMScaffold

@Composable
fun BorrowScreen(navController: NavHostController) {
    MGMScaffold(
        title = "Peminjaman",
        showBackButton = true,
        navController = navController,
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 24.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Image(
                painter = painterResource(R.drawable.peminjaman_flow),
                contentDescription = "Diagram alur peminjaman",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(16f / 9f)
                    .padding(vertical = 16.dp)
            )

            Text(
                text = "Penjelasan",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            BorrowSteps()

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}