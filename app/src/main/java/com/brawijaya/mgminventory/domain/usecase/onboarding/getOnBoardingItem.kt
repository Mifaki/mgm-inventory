package com.brawijaya.mgminventory.domain.usecase.onboarding

import com.brawijaya.mgminventory.R
import com.brawijaya.mgminventory.data.model.OnboardingItem

fun getOnBoardingItem():List<OnboardingItem> {
    return listOf(
        OnboardingItem(
            title = "Atur jadwal peminjaman pilihan barangmu!",
            description = "MGM membantu Anda untuk memudahkan peminjaman barangmu",
            imageResId = R.drawable.boarding_1
        ),
        OnboardingItem(
            title = "Pastikan pilihan barang yang Anda pinjam sesuai kebutuhanmu!",
            description = "Cari dan baca secara seksama pilihan barang laboratorium yang disediakan oleh MGM. Pilih barang sesuai kebutuhan untuk mencapai kesuksesan acaramu!",
            imageResId = R.drawable.boarding_2
        ),
        OnboardingItem(
            title = "Pinjam sekarang!",
            description = "Mari maksimalkan fasilitas kampus melalui peminjaman barang pada Lab MGM!",
            imageResId = R.drawable.boarding_3
        )
    )
}