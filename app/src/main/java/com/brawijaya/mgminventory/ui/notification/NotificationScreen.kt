package com.brawijaya.mgminventory.ui.notification

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.brawijaya.mgminventory.data.model.NotificationType
import com.brawijaya.mgminventory.domain.notification.getNotificationItem
import com.brawijaya.mgminventory.ui.components.MGMScaffold
import com.brawijaya.mgminventory.ui.notification.components.EmptyNotifications
import com.brawijaya.mgminventory.ui.notification.components.NotificationsList

@Composable
fun NotificationScreen(navController: NavHostController) {

    val notifications = remember { getNotificationItem() }

    MGMScaffold(
        title = "Notifikasi",
        showBackButton = false,
        navController = navController,
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 32.dp, horizontal = 8.dp)
        ) {
            if (notifications.isEmpty()) {
                EmptyNotifications(modifier = Modifier.align(Alignment.Center))
            } else {
                NotificationsList(
                    notifications = notifications,
                    onNotificationClick = { notification ->
                        when (notification.type) {
                            NotificationType.ANNOUNCEMENT -> {
                                navController.navigate("notification_detail/announcement/${notification.id}")
                            }
                            NotificationType.RETURN -> {
                                navController.navigate("notification_detail/return/${notification.id}")
                            }
                        }
                    }
                )
            }
        }
    }
}