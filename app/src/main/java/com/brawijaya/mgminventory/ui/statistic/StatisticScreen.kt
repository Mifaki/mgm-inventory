package com.brawijaya.mgminventory.ui.statistic

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.brawijaya.mgminventory.domain.statistic.getStatItem
import com.brawijaya.mgminventory.ui.components.BarChart
import com.brawijaya.mgminventory.ui.components.MGMScaffold
import com.brawijaya.mgminventory.ui.components.MonthSelector
import com.brawijaya.mgminventory.ui.statistic.components.DetailSection

@Composable
fun StatisticScreen(navController: NavHostController) {

    val barItems = getStatItem()

    MGMScaffold(
        title = "Data Statistik",
        showBackButton = true,
        navController = navController
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp, start = 24.dp, end = 24.dp)
        ) {
            MonthSelector()

            BarChart(values = barItems)
            DetailSection(items = barItems)
        }
    }
}