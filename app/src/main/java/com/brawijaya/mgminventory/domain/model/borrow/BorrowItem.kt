package com.brawijaya.mgminventory.domain.model.borrow

data class BorrowItem (
    val id: String,
    val itemName: String,
    val borrowDate: String,
    val returnDate: String,
    val status: String
)