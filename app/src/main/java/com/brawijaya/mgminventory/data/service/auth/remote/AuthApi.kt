package com.brawijaya.mgminventory.data.service.auth.remote

import com.brawijaya.mgminventory.data.service.auth.dto.LoginRequest
import com.brawijaya.mgminventory.data.service.auth.dto.LoginResponse
import com.brawijaya.mgminventory.data.service.auth.dto.RegisterRequest
import com.brawijaya.mgminventory.data.service.auth.dto.RegisterResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {
    @POST("auth/login")
    suspend fun login (
        @Body request: LoginRequest
    ): LoginResponse

    @POST("auth/register")
    suspend fun register (
        @Body request: RegisterRequest
    ): RegisterResponse
}