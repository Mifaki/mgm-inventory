package com.brawijaya.mgminventory.domain.usecase.onboarding

import com.brawijaya.mgminventory.data.model.BarItem

fun getBarItem(): List<BarItem> {
    return listOf(
        BarItem("X 360", 70f, true),
        BarItem("X KINECT", 40f, true),
        BarItem("Cardport VR", 70f, true),
        BarItem("Joystick", 40f, true),
        BarItem("Meta Quest", 70f, true),
        BarItem("Occulight", 40f, true),
        BarItem("Nama Barang 7", 0f, false),
        BarItem("Nama Barang 8", 0f, false)
    )
}