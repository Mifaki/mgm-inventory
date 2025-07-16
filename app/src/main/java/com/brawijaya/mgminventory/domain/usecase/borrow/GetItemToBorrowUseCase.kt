package com.brawijaya.mgminventory.domain.usecase.borrow

import com.brawijaya.mgminventory.data.repository.borrow.BorrowRepository
import com.brawijaya.mgminventory.domain.model.borrow.LabItem
import com.brawijaya.mgminventory.utlis.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetItemToBorrowUseCase @Inject constructor(
    private val _repository: BorrowRepository
) {
    suspend operator fun invoke(): Flow<Resource<List<LabItem>>> {
        return _repository.getItems()
    }
}