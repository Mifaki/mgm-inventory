package com.brawijaya.mgminventory.domain.usecase.onboarding

import com.brawijaya.mgminventory.R
import com.brawijaya.mgminventory.data.model.BottomNavItem

fun getBottomBarItem(): List<BottomNavItem> {
    return listOf(
        BottomNavItem("Home", R.drawable.home_bottom, "home"),
        BottomNavItem("Docs", R.drawable.docs_bottom, "peminjaman"),
        BottomNavItem("History", R.drawable.history_bottom, "history"),
        BottomNavItem("Profile", R.drawable.profile_bottom, "Profile")
    )
}