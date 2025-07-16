package com.brawijaya.mgminventory.data.service.borrow.remote

import com.brawijaya.mgminventory.data.service.borrow.dto.AddBorrowResponse
import com.brawijaya.mgminventory.data.service.borrow.dto.GetItemResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface BorrowApi {
    @GET("borrow/items")
    suspend fun getItems(): GetItemResponse

    @Multipart
    @POST("borrow")
    suspend fun addBorrow(
        @Part("itemId") itemId: RequestBody,
        @Part("userName") userName: RequestBody,
        @Part("userEmail") userEmail: RequestBody,
        @Part("userNIM") userNIM: RequestBody,
        @Part("userProgramStudy") userProgramStudy: RequestBody,
        @Part("reason") reason: RequestBody,
        @Part("borrowDate") borrowDate: RequestBody,
        @Part("pickupDate") pickupDate: RequestBody,
        @Part("returnDate") returnDate: RequestBody,
        @Part userKTM: MultipartBody.Part
    ): AddBorrowResponse
}