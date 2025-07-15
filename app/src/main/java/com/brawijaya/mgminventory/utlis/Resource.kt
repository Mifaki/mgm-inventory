package com.brawijaya.mgminventory.utlis

import com.brawijaya.mgminventory.domain.model.user.User
import kotlinx.coroutines.flow.MutableStateFlow

sealed class Resource<out T> {
    data object Idle : Resource<Nothing>()
    data object Loading : Resource<Nothing>()
    data class Success<out T>(val data: T) : Resource<T>()
    data class Error(val message: String) : Resource<Nothing>()
}
