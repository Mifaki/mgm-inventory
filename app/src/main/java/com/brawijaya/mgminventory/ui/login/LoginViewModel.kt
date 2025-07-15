package com.brawijaya.mgminventory.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.brawijaya.mgminventory.domain.model.user.User
import com.brawijaya.mgminventory.domain.usecase.auth.LoginUseCase
import com.brawijaya.mgminventory.utlis.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val _loginUseCase: LoginUseCase,
): ViewModel() {
    private val _loginState = MutableStateFlow<Resource<User>>(Resource.Idle)
    val loginState: StateFlow<Resource<User>> = _loginState

    fun login (nim: String, password: String) {
        viewModelScope.launch {
            _loginUseCase(nim, password).collect() {
                _loginState.value = it
            }
        }
    }
}