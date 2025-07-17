package com.brawijaya.mgminventory.data.service.borrow.dto

import java.io.File

data class AddReturnItemRequest (
    val itemId: String,
    val borrowDate: String,
    val returnDate: String,
    val damagedItem: File
)