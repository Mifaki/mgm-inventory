package com.brawijaya.mgminventory.ui.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.brawijaya.mgminventory.data.repository.authentication.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val _authRepository: AuthRepository
): ViewModel() {
    fun logout() {
        viewModelScope.launch {
            _authRepository.logout()
        }
    }
}