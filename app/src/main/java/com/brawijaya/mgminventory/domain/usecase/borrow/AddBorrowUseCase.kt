package com.brawijaya.mgminventory.domain.usecase.borrow

import com.brawijaya.mgminventory.data.repository.borrow.BorrowRepository
import com.brawijaya.mgminventory.data.service.borrow.dto.AddBorrowRequest
import com.brawijaya.mgminventory.data.service.borrow.dto.AddBorrowResponse
import com.brawijaya.mgminventory.utlis.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AddBorrowUseCase @Inject constructor(
    private val repository: BorrowRepository
) {
    suspend operator fun invoke(request: AddBorrowRequest): Flow<Resource<AddBorrowResponse>> {
        return repository.addBorrow(request)
    }
}
