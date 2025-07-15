package com.brawijaya.mgminventory.domain.usecase.auth

import com.brawijaya.mgminventory.data.repository.authentication.AuthRepository
import com.brawijaya.mgminventory.domain.model.user.User
import com.brawijaya.mgminventory.utlis.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val _authRepository: AuthRepository
) {
    suspend operator fun invoke(
        email: String,
        password: String
    ): Flow<Resource<User>> {
        return _authRepository.login(email, password)
    }
}