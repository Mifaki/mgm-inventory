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
import androidx.navigation.NavHostController
import com.brawijaya.mgminventory.domain.scaffold.getBottomBarItem
import com.brawijaya.mgminventory.ui.navigation.Screen

@Composable
fun MGMScaffold(
    title: String,
    showBackButton: Boolean = false,
    showTopBar: Boolean = true,
    showBottomBar: Boolean = true,
    navController: NavHostController,
    content: @Composable () -> Unit,
) {

    var selectedItemIndex by rememberSaveable { mutableStateOf(0) }

    Scaffold(topBar = {
        if (showTopBar) {
            MGMTopBar(
                title = title,
                showBackButton = showBackButton,
                onBackPressed = { navController.popBackStack() },
                onNotificationPressed = { navController.navigate(Screen.Notification.route)},
                notificationCount = 1,
            )
        }
    }, bottomBar = {
        if (showBottomBar) {
            MGMBottomBar(
                items = getBottomBarItem(),
                selectedItemIndex = selectedItemIndex,
                navController = navController,
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