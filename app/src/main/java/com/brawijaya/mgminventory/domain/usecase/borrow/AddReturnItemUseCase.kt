package com.brawijaya.mgminventory.domain.usecase.borrow

import com.brawijaya.mgminventory.data.repository.borrow.BorrowRepository
import com.brawijaya.mgminventory.data.service.borrow.dto.AddReturnItemRequest
import com.brawijaya.mgminventory.data.service.borrow.dto.AddReturnItemResponse
import com.brawijaya.mgminventory.utlis.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AddReturnItemUseCase @Inject constructor(
    private val _repository: BorrowRepository
) {
    suspend operator fun invoke(request: AddReturnItemRequest): Flow<Resource<AddReturnItemResponse>> {
        return _repository.addReturnItem(request)
    }
}