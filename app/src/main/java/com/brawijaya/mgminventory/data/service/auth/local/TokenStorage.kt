package com.brawijaya.mgminventory.data.service.auth.local

import android.content.Context
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TokenStorage @Inject constructor(
    context: Context
) {
    private val prefs = EncryptedSharedPreferences.create(
        "token_keys",
        MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC),
        context,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )

    fun saveToken(access: String, refresh: String) {
        prefs.edit()
            .putString("access_token", access)
            .putString("refresh_token", refresh)
            .apply()
    }

    fun getAccessToken() {
        prefs.getString("access_token", null)
    }

    fun getRefreshToken() {
        prefs.getString("refresh_token", null)
    }

    fun clearToken() {
        prefs.edit().clear().apply()
    }
}