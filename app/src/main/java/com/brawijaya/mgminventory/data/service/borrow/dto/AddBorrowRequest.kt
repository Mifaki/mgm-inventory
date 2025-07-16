package com.brawijaya.mgminventory.data.service.borrow.dto

import java.io.File

data class AddBorrowRequest(
    val itemId: String,
    val userName: String,
    val userEmail: String,
    val userNIM: String,
    val userProgramStudy: String,
    val reason: String,
    val borrowDate: String,
    val pickupDate: String,
    val returnDate: String,
    val userKTM: File
)
