package com.brawijaya.mgminventory.data.repository.authentication

import android.media.session.MediaSession.Token
import com.brawijaya.mgminventory.data.service.auth.dto.LoginRequest
import com.brawijaya.mgminventory.data.service.auth.dto.UserLoginResponse
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

    private fun UserLoginResponse.toDomain(): User {
        return User(
            id = id.toString(),
            name = name,
            email = email
        )
    }
}