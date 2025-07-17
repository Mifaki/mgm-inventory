package com.brawijaya.mgminventory.data.repository.borrow

import android.util.Log
import com.brawijaya.mgminventory.data.service.borrow.dto.AddBorrowRequest
import com.brawijaya.mgminventory.data.service.borrow.dto.AddBorrowResponse
import com.brawijaya.mgminventory.data.service.borrow.dto.AddReturnItemRequest
import com.brawijaya.mgminventory.data.service.borrow.dto.AddReturnItemResponse
import com.brawijaya.mgminventory.data.service.borrow.dto.DataBorrowResponse
import com.brawijaya.mgminventory.data.service.borrow.dto.LabItemsResponse
import com.brawijaya.mgminventory.data.service.borrow.local.labItemsData
import com.brawijaya.mgminventory.data.service.borrow.remote.BorrowApi
import com.brawijaya.mgminventory.domain.model.borrow.BorrowItem
import com.brawijaya.mgminventory.domain.model.borrow.LabItem
import com.brawijaya.mgminventory.utlis.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.File
import javax.inject.Inject

interface BorrowRepository {
    suspend fun getItems(): Flow<Resource<List<LabItem>>>
    suspend fun addBorrow(
        request: AddBorrowRequest
    ): Flow<Resource<AddBorrowResponse>>

    suspend fun getBorrowItems(): Flow<Resource<List<BorrowItem>>>
    suspend fun addReturnItem(
        request: AddReturnItemRequest
    ): Flow<Resource<AddReturnItemResponse>>
}

class BorrowRepositoryImplementation @Inject constructor(
    private val _api: BorrowApi,
) : BorrowRepository {
    override suspend fun getItems(): Flow<Resource<List<LabItem>>> = flow {
        emit(Resource.Loading)

        try {
            val response = _api.getItems()
            val items = response.data.map { it.toDomain() }
            emit(Resource.Success(items))
        } catch (e: Exception) {
            emit(Resource.Error(e.message ?: "Unknown error"))
        }
    }

    override suspend fun addBorrow(
        request: AddBorrowRequest
    ): Flow<Resource<AddBorrowResponse>> = flow {
        emit(Resource.Loading)

        try {
            val response = _api.addBorrow(
                itemId = request.itemId.toRequestBody("text/plain".toMediaTypeOrNull()),
                userName = request.userName.toRequestBody("text/plain".toMediaTypeOrNull()),
                userEmail = request.userEmail.toRequestBody("text/plain".toMediaTypeOrNull()),
                userNIM = request.userNIM.toRequestBody("text/plain".toMediaTypeOrNull()),
                userProgramStudy = request.userProgramStudy.toRequestBody("text/plain".toMediaTypeOrNull()),
                reason = request.reason.toRequestBody("text/plain".toMediaTypeOrNull()),
                borrowDate = request.borrowDate.toRequestBody("text/plain".toMediaTypeOrNull()),
                pickupDate = request.pickupDate.toRequestBody("text/plain".toMediaTypeOrNull()),
                returnDate = request.returnDate.toRequestBody("text/plain".toMediaTypeOrNull()),
                userKTM = prepareImagePart("userKTM", request.userKTM)
            )

            emit(Resource.Success(response))
        } catch (e: Exception) {
            emit(Resource.Error(e.message ?: "Unknown error"))
        }
    }

    override suspend fun getBorrowItems(): Flow<Resource<List<BorrowItem>>> = flow {
        emit(Resource.Loading)

        try {
            val response = _api.getBorrowItems()
            val items = response.data.map { it.toDomain() }

            emit(Resource.Success(items))
        } catch (e: Exception) {
            emit(Resource.Error(e.message ?: "Unknown error"))
        }
    }

    override suspend fun addReturnItem(request: AddReturnItemRequest): Flow<Resource<AddReturnItemResponse>> =
        flow {
            emit(Resource.Loading)

            try {
                val response = _api.addReturnItem(
                    itemId = request.itemId.toRequestBody("text/plain".toMediaTypeOrNull()),
                    borrowDate = request.borrowDate.toRequestBody("text/plain".toMediaTypeOrNull()),
                    returnDate = request.returnDate.toRequestBody("text/plain".toMediaTypeOrNull()),
                    damagedItem = prepareImagePart("damagedItem", request.damagedItem)
                )

                emit(Resource.Success(response))
            } catch (e: Exception) {
                emit(Resource.Error(e.message ?: "Unknown error"))
            }
        }

    private fun LabItemsResponse.toDomain(): LabItem {
        return LabItem(
            id = id,
            name = name,
            quantity = quantity
        )
    }

    private fun DataBorrowResponse.toDomain(): BorrowItem {
        return BorrowItem(
            id = itemId,
            itemName = labItemsData.find { it.id == itemId }?.name ?: "Unknown Item",
            borrowDate = borrowDate,
            returnDate = returnDate,
            status = status
        )
    }

    private fun prepareImagePart(partName: String, file: File): MultipartBody.Part {
        val requestFile = file.asRequestBody("image/*".toMediaTypeOrNull())
        return MultipartBody.Part.createFormData(partName, file.name, requestFile)
    }
}