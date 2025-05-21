package com.brawijaya.mgminventory.ui.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.brawijaya.mgminventory.domain.statistic.getStatItem
import com.brawijaya.mgminventory.ui.components.BarChart
import com.brawijaya.mgminventory.ui.components.MonthSelector
import com.brawijaya.mgminventory.ui.navigation.Screen

@Composable
fun DataStatistikSection(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp)
    ) {

        Text(
            modifier = Modifier.fillMaxWidth().padding(top = 24.dp, bottom = 24.dp),
            text = "Data Statistik",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            MonthSelector()

            TextButton(onClick = { navController.navigate(Screen.Statistic.route) }) {
                Text(
                    text = "Lihat Detail",
                    color = Color(0xFF3F51B5)
                )
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        BarChart(values = getStatItem())
    }
}