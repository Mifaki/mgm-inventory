package com.brawijaya.mgminventory.ui.itemreturn.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.brawijaya.mgminventory.ui.components.BulletListItem
import com.brawijaya.mgminventory.ui.components.OrderedListItem

@Composable
fun ItemReturnSteps() {
    Column(
    modifier = Modifier.fillMaxWidth()
    ) {
        OrderedListItem(
            number = 1,
            title = "Login",
            description = ""
        )

        Column(modifier = Modifier.padding(start = 24.dp)) {
            BulletListItem("Mahasiswa login kembali ke sistem untuk memulai proses pengembalian.")
        }

        OrderedListItem(
            number = 2,
            title = "Isi Formulir Pengembalian",
            description = ""
        )

        Column(modifier = Modifier.padding(start = 24.dp)) {
            BulletListItem("Mahasiswa mengisi form pengembalian: daftar alat yang dikembalikan, tanggal pengembalian, kondisi alat, serta upload bukti (foto, dsb).")
        }

        OrderedListItem(
            number = 3,
            title = "Konfirmasi",
            description = ""
        )

        Column(modifier = Modifier.padding(start = 24.dp)) {
            BulletListItem("Data dikirim dan dikonfirmasi untuk dicek oleh admin laboratorium.")
        }

        OrderedListItem(
            number = 4,
            title = "Verifikasi oleh Admin",
            description = ""
        )

        Column(modifier = Modifier.padding(start = 24.dp)) {
            BulletListItem("Admin memverifikasi keakuratan data pengembalian.")
            BulletListItem("Jika tidak diterima, mahasiswa perlu mengulangi proses pengisian.")
            BulletListItem("Jika diterima, pengembalian dianggap sah.")
        }

        OrderedListItem(
            number = 5,
            title = "Serah Terima Alat",
            description = ""
        )

        Column(modifier = Modifier.padding(start = 24.dp)) {
            BulletListItem("Mahasiswa menemui Kepala Laboratorium untuk mengembalikan alat secara fisik sesuai jadwal.")
        }
    }
}