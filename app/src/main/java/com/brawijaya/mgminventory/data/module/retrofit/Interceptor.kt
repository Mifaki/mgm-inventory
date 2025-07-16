package com.brawijaya.mgminventory.data.module.retrofit

import com.brawijaya.mgminventory.data.service.auth.local.TokenStorage
import okhttp3.Interceptor
import okhttp3.Response

class TokenInterceptor(
    private val _tokenStorage: TokenStorage
): Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()
        val token = _tokenStorage.getAccessToken()

        if (!token.isNullOrBlank()) {
            requestBuilder.addHeader("Authorization", "Bearer $token")
        }
        return chain.proceed(requestBuilder.build())
    }
}