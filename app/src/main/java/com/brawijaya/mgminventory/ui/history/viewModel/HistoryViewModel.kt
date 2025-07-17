package com.brawijaya.mgminventory.ui.history.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.brawijaya.mgminventory.domain.model.borrow.BorrowItem
import com.brawijaya.mgminventory.domain.usecase.borrow.GetBorrowListUseCase
import com.brawijaya.mgminventory.utlis.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(
    private val _getItemsUseCase: GetBorrowListUseCase
): ViewModel() {
    private val _itemsState = MutableStateFlow<Resource<List<BorrowItem>>>(Resource.Idle)
    val itemsState: StateFlow<Resource<List<BorrowItem>>> = _itemsState

    fun getItems() {
        viewModelScope.launch {
            _getItemsUseCase().collect() {
                _itemsState.value = it
            }
        }
    }

}