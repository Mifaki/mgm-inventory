package com.brawijaya.mgminventory.data.service.auth.dto

data class LoginResponse (
    val data: LoginDataResponse
)

data class LoginDataResponse (
    val accessToken: String,
    val refreshToken: String,
    val user: AuthUserResponse
)