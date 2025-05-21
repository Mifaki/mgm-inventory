package com.brawijaya.mgminventory.data.model

enum class NotificationType {
    ANNOUNCEMENT,
    RETURN
}

data class NotificationItem(
    val id: String,
    val title: String,
    val type: NotificationType,
    val date: String
)

data class ReturnNotificationDetail(
    val title: String,
    val endTime: String,
    val borrowDate: String,
    val returnDate: String,
    val item: String,
    val proofImageUrl: String
)

data class AnnouncementDetail(
    val title: String,
    val endTime: String,
    val imageUrl: String
)