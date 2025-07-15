package com.brawijaya.mgminventory.ui.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.brawijaya.mgminventory.domain.model.user.User
import com.brawijaya.mgminventory.domain.usecase.auth.RegisterUseCase
import com.brawijaya.mgminventory.utlis.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val _registerUseCase: RegisterUseCase
): ViewModel() {
    private val _registerState = MutableStateFlow<Resource<User>>(Resource.Idle)
    val registerState: StateFlow<Resource<User>> = _registerState

    fun register (
        nim: String,
        name: String,
        email: String,
        password: String
    ) {
        viewModelScope.launch {
            _registerUseCase(nim, name, email, password).collect() {
                _registerState.value = it
            }
        }
    }
}