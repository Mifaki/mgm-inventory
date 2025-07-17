package com.brawijaya.mgminventory.domain.usecase.borrow

import com.brawijaya.mgminventory.data.repository.borrow.BorrowRepository
import com.brawijaya.mgminventory.domain.model.borrow.BorrowItem
import com.brawijaya.mgminventory.utlis.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetBorrowListUseCase @Inject constructor(
    private val _repository: BorrowRepository
) {
    suspend operator fun invoke(): Flow<Resource<List<BorrowItem>>> {
        return _repository.getBorrowItems()
    }
}