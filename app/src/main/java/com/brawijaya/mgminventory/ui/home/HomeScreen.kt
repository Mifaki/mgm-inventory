package com.brawijaya.mgminventory.ui.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.brawijaya.mgminventory.ui.components.MGMScaffold
import com.brawijaya.mgminventory.ui.home.components.DataStatistikSection
import com.brawijaya.mgminventory.ui.home.components.FlowSection
import com.brawijaya.mgminventory.ui.home.components.PunishmentSection
import com.brawijaya.mgminventory.ui.home.components.TestimoniSection

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen() {
    MGMScaffold(
        title = "Beranda",
        showBackButton = false,
    ) {
        Column (
            modifier = Modifier
                .padding(horizontal = 24.dp)
                .verticalScroll(rememberScrollState())
        ) {
            DataStatistikSection()
            FlowSection()
            PunishmentSection()
            TestimoniSection()
        }
    }
}