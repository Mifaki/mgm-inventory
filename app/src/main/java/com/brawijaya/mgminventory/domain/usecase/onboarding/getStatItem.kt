package com.brawijaya.mgminventory.domain.usecase.onboarding

import com.brawijaya.mgminventory.data.model.StatItem

fun getStatItem(): List<StatItem> {
    return listOf(
        StatItem("X 360", 70f, true),
        StatItem("X KINECT", 40f, true),
        StatItem("Cardport VR", 70f, true),
        StatItem("Joystick", 40f, true),
        StatItem("Meta Quest", 70f, true),
        StatItem("Occulight", 40f, true),
        StatItem("Nama Barang 7", 0f, false),
        StatItem("Nama Barang 8", 0f, false)
    )
}