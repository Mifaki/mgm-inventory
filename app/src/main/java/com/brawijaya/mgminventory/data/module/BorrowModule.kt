package com.brawijaya.mgminventory.data.module

import com.brawijaya.mgminventory.data.repository.authentication.AuthRepository
import com.brawijaya.mgminventory.data.repository.authentication.AuthRepositoryImplementation
import com.brawijaya.mgminventory.data.repository.borrow.BorrowRepository
import com.brawijaya.mgminventory.data.repository.borrow.BorrowRepositoryImplementation
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class BorrowModule {

    @Binds
    @Singleton
    abstract fun bindBorrowRepository(
        impl: BorrowRepositoryImplementation
    ): BorrowRepository
}