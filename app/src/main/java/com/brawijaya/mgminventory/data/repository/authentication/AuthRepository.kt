package com.brawijaya.mgminventory.data.repository.authentication

import android.media.session.MediaSession.Token
import android.util.Log
import com.brawijaya.mgminventory.data.service.auth.dto.AuthUserResponse
import com.brawijaya.mgminventory.data.service.auth.dto.LoginRequest
import com.brawijaya.mgminventory.data.service.auth.dto.RegisterRequest
import com.brawijaya.mgminventory.data.service.auth.local.TokenStorage
import com.brawijaya.mgminventory.data.service.auth.remote.AuthApi
import com.brawijaya.mgminventory.domain.model.user.User
import com.brawijaya.mgminventory.utlis.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface AuthRepository {
    suspend fun login(
        nim: String,
        password: String
    ): Flow<Resource<User>>

    suspend fun register(
        name: String,
        email: String,
        nim: String,
        password: String
    ): Flow<Resource<User>>
}

class AuthRepositoryImplementation @Inject constructor(
    private val _api: AuthApi,
    private val _tokenStorage: TokenStorage
): AuthRepository {
    override suspend fun login(nim: String, password: String): Flow<Resource<User>> = flow {
        emit(Resource.Loading)

        if (nim.isBlank() || password.isBlank()) {
            emit(Resource.Error("Nim or Password is empty"))
            return@flow
        }

        try {
            val response = _api.login(LoginRequest(nim, password))

            _tokenStorage.saveToken(response.data.accessToken, response.data.refreshToken)
            emit(Resource.Success(response.data.user.toDomain()))
        } catch (e: Exception) {
            emit(Resource.Error(e.toString() ?: "Login: Something Went Wrong"))
        }
    }

    override suspend fun register(
        name: String,
        email: String,
        nim: String,
        password: String
    ): Flow<Resource<User>> = flow {
        emit(Resource.Loading)

        try {
            val response = _api.register(RegisterRequest(
                name, email, nim, password
            ))
            Log.i("Register", response.toString())

            emit(Resource.Success(response.data.toDomain()))
        } catch (e: Exception) {
            emit(Resource.Error(e.toString() ?: "Register: Something Went Wrong"))
            Log.e("Register", e.toString())
        }
    }

    private fun AuthUserResponse.toDomain(): User {
        return User(
            id = id.toString(),
            name = name,
            email = email
        )
    }
}