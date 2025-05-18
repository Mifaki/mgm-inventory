package com.brawijaya.mgminventory.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.brawijaya.mgminventory.domain.usecase.onboarding.getBottomBarItem

@Composable
fun MGMScaffold(
    title: String,
    showBackButton: Boolean = false,
    onBackPressed: () -> Unit = {},
    showBottomBar: Boolean = true,
    content: @Composable () -> Unit
) {

    var selectedItemIndex by rememberSaveable { mutableStateOf(0) }

    Scaffold(topBar = {
        MGMTopBar(
            title = title,
            showBackButton = showBackButton,
            onBackPressed = onBackPressed,
            notificationCount = 1
        )
    }, bottomBar = {
        if (showBottomBar) {
            MGMBottomBar(
                items = getBottomBarItem(),
                selectedItemIndex = selectedItemIndex,
                onItemSelected = { selectedItemIndex = it })
        }
    }) { paddingValues ->
        Surface(
            modifier = Modifier.padding(paddingValues), color = Color.White
        ) {
            content()
        }
    }
}