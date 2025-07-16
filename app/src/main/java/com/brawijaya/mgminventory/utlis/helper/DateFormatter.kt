package com.brawijaya.mgminventory.utlis.helper

import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun String.reformatToDMY(): String {
    return try {
        val inputFormat = DateTimeFormatter.ofPattern("dd-mm-yyyy")
        val outputFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy")
        val parsedDate = LocalDate.parse(this, inputFormat)
        parsedDate.format(outputFormat)
    } catch (e: Exception) {
        this
    }
}
