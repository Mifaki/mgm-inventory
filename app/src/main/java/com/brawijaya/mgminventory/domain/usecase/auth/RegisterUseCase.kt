package com.brawijaya.mgminventory.domain.usecase.auth

import android.util.Log
import com.brawijaya.mgminventory.data.repository.authentication.AuthRepository
import com.brawijaya.mgminventory.domain.model.user.User
import com.brawijaya.mgminventory.utlis.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RegisterUseCase @Inject constructor(
    private val _repository: AuthRepository
) {
    suspend operator fun invoke(
        name: String,
        email: String,
        nim: String,
        password: String
    ): Flow<Resource<User>> {
        return _repository.register(
            name, email, nim, password
        )
    }
}