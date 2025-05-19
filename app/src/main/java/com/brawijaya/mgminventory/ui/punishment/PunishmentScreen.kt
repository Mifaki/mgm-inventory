package com.brawijaya.mgminventory.ui.punishment

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import com.brawijaya.mgminventory.ui.components.MGMScaffold

@Composable
fun PunishmentScreen(navController: NavHostController) {
    MGMScaffold(
        title = "Sanksi",
        showBackButton = true,
        navController = navController
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 24.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                text = "Keterlambatan Pengembalian",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(top = 24.dp)
            )

            Image(
                painter = painterResource(R.drawable.late_punishment),
                contentDescription = "Sanksi Keterlambatan",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(16f / 9f)
            )

            Text(
                text = "Kehilangan Barang Peminjaman",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold,
            )

            Image(
                painter = painterResource(R.drawable.lost_punishment),
                contentDescription = "Sanksi Kehilangan Barang",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(16f / 9f)
            )
        }
    }
}