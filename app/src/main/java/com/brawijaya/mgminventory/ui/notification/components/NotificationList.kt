package com.brawijaya.mgminventory.ui.notification.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.brawijaya.mgminventory.R
import com.brawijaya.mgminventory.data.model.NotificationItem
import com.brawijaya.mgminventory.data.model.NotificationType

@Composable
fun NotificationsList(
    notifications: List<NotificationItem>,
    onNotificationClick: (NotificationItem) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(notifications) { notification ->
            NotificationListItem(
                notification = notification,
                onClick = { onNotificationClick(notification) }
            )
            Divider(
                modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                color = Color(0xFFEEEEEE)
            )
        }
    }
}

@Composable
fun NotificationListItem(
    notification: NotificationItem,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            contentAlignment = Alignment.Center
        ) {
            val icon = when (notification.type) {
                NotificationType.ANNOUNCEMENT -> R.drawable.calender
                NotificationType.RETURN -> R.drawable.notification
            }
            Icon(
                painter = painterResource(icon),
                contentDescription = null,
                tint = Color.Black
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = notification.title,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = notification.date,
                fontSize = 14.sp,
                color = Color.Gray
            )
        }
    }
}
