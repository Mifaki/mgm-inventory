package com.brawijaya.mgminventory.ui.notificationdetail

import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import com.brawijaya.mgminventory.ui.notificationdetail.components.AnnouncementDetailForm
import com.brawijaya.mgminventory.ui.notificationdetail.components.ReturnDetailForm

@Composable
fun NotificationDetailScreen(
    navController: NavHostController,
    notificationType: String,
    notificationId: String
) {
    when (notificationType) {
        "return" -> ReturnDetailForm(navController, notificationId)
        "announcement" -> AnnouncementDetailForm(navController, notificationId)
    }
}