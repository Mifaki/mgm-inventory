package com.brawijaya.mgminventory.ui.borrow.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.brawijaya.mgminventory.ui.components.BulletListItem
import com.brawijaya.mgminventory.ui.components.OrderedListItem


@Composable
fun BorrowSteps() {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        OrderedListItem(
            number = 1,
            title = "Login ke Sistem",
            description = "Pengguna (mahasiswa) melakukan autentikasi untuk masuk ke sistem menggunakan akun resmi (misalnya akun UB)."
        )

        OrderedListItem(
            number = 2,
            title = "Isi Formulir Peminjaman",
            description = "Pengguna mengisi form yang tersedia dengan data seperti:"
        )

        Column(modifier = Modifier.padding(start = 24.dp)) {
            BulletListItem("Nama peminjam")
            BulletListItem("NIM")
            BulletListItem("Nama barang")
            BulletListItem("Tanggal peminjaman dan pengembalian")
            BulletListItem("Keperluan peminjaman")
            BulletListItem("Upload KTM")
        }

        OrderedListItem(
            number = 3,
            title = "Konfirmasi Peminjaman",
            description = "Setelah form terisi, pengguna melakukan konfirmasi untuk mengirimkan data peminjaman ke sistem."
        )

        OrderedListItem(
            number = 4,
            title = "Proses Verifikasi / Validasi",
            description = "Permintaan peminjaman akan diverifikasi oleh admin atau kepala lab."
        )

        OrderedListItem(
            number = 5,
            title = "Keputusan Verifikasi",
            description = ""
        )

        Column(modifier = Modifier.padding(start = 24.dp)) {
            BulletListItem("Jika tidak diterima → sistem akan mengarahkan kembali pengguna ke langkah \"Isi Formulir\" untuk koreksi atau pemrosesan ulang.")
            BulletListItem("Jika diterima → pengguna mendapat izin untuk meminjam alat.")
        }

        OrderedListItem(
            number = 6,
            title = "Pengambilan Barang",
            description = "Pengguna diarahkan untuk menemui Kepala Laboratorium sesuai dengan jadwal/tanggal pengambilan dan pengembalian barang."
        )
    }
}