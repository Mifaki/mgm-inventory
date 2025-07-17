package com.brawijaya.mgminventory.data.service.borrow.dto

data class GetBorrowResponse(
    val data: List<DataBorrowResponse>
)

data class DataBorrowResponse(
    val itemId: String,
    val userName: String,
    val userEmail: String,
    val userNIM: String,
    val userProgramStudy: String,
    val reason: String,
    val borrowDate: String,
    val returnDate: String,
    val status: String
)