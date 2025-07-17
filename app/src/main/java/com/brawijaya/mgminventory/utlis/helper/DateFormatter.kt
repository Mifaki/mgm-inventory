package com.brawijaya.mgminventory.utlis.helper

import java.time.LocalDate
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter

fun String.formatIsoToDMY(): String {
    return try {
        val inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX")
        val outputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
        val date = OffsetDateTime.parse(this, inputFormatter)
        date.format(outputFormatter)
    } catch (e: Exception) {
        this
    }
}
