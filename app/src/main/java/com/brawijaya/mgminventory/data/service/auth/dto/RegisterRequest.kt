package com.brawijaya.mgminventory.data.service.auth.dto

data class RegisterRequest (
    val name: String,
    val email: String,
    val nim: String,
    val password: String
)