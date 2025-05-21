package com.brawijaya.mgminventory.domain.notification

import com.brawijaya.mgminventory.data.model.NotificationItem
import com.brawijaya.mgminventory.data.model.NotificationType

fun getNotificationItem(): List<NotificationItem> {
    return listOf(
        NotificationItem(
            id = "1",
            title = "X-BOX 360 telah ditambahkan",
            type = NotificationType.RETURN,
            date = "Aug 12, 2020 at 12:08 PM"
        ),
        NotificationItem(
            id = "2",
            title = "Selamat Hari Natal!",
            type = NotificationType.ANNOUNCEMENT,
            date = "Aug 12, 2020 at 12:08 PM"
        ),
        NotificationItem(
            id = "3",
            title = "Joystick berhasil dikembalikan",
            type = NotificationType.RETURN,
            date = "Aug 11, 2020 at 12:08 PM"
        ),
        NotificationItem(
            id = "4",
            title = "Meta Quest berhasil dikembalikan",
            type = NotificationType.RETURN,
            date = "Aug 10, 2020 at 12:08 PM"
        ),
        NotificationItem(
            id = "5",
            title = "Oculusrift telah dikembalikan",
            type = NotificationType.RETURN,
            date = "Aug 09, 2020 at 12:08 PM"
        ),
        NotificationItem(
            id = "1",
            title = "X-BOX 360 telah ditambahkan",
            type = NotificationType.RETURN,
            date = "Aug 12, 2020 at 12:08 PM"
        ),
        NotificationItem(
            id = "2",
            title = "Selamat Hari Natal!",
            type = NotificationType.ANNOUNCEMENT,
            date = "Aug 12, 2020 at 12:08 PM"
        ),
        NotificationItem(
            id = "3",
            title = "Joystick berhasil dikembalikan",
            type = NotificationType.RETURN,
            date = "Aug 11, 2020 at 12:08 PM"
        ),
        NotificationItem(
            id = "4",
            title = "Meta Quest berhasil dikembalikan",
            type = NotificationType.RETURN,
            date = "Aug 10, 2020 at 12:08 PM"
        ),
        NotificationItem(
            id = "5",
            title = "Oculusrift telah dikembalikan",
            type = NotificationType.RETURN,
            date = "Aug 09, 2020 at 12:08 PM"
        ),
        NotificationItem(
            id = "1",
            title = "X-BOX 360 telah ditambahkan",
            type = NotificationType.RETURN,
            date = "Aug 12, 2020 at 12:08 PM"
        ),
        NotificationItem(
            id = "2",
            title = "Selamat Hari Natal!",
            type = NotificationType.ANNOUNCEMENT,
            date = "Aug 12, 2020 at 12:08 PM"
        ),
        NotificationItem(
            id = "3",
            title = "Joystick berhasil dikembalikan",
            type = NotificationType.RETURN,
            date = "Aug 11, 2020 at 12:08 PM"
        ),
        NotificationItem(
            id = "4",
            title = "Meta Quest berhasil dikembalikan",
            type = NotificationType.RETURN,
            date = "Aug 10, 2020 at 12:08 PM"
        ),
        NotificationItem(
            id = "5",
            title = "Oculusrift telah dikembalikan",
            type = NotificationType.RETURN,
            date = "Aug 09, 2020 at 12:08 PM"
        )
    )
}