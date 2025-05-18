package com.brawijaya.mgminventory.data.model

import androidx.annotation.DrawableRes

data class BottomNavItem(
    val title: String,
    @DrawableRes val iconResId: Int,
    val route: String
)