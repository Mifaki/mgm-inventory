package com.brawijaya.mgminventory.data.module

import com.brawijaya.mgminventory.data.repository.authentication.AuthRepository
import com.brawijaya.mgminventory.data.repository.authentication.AuthRepositoryImplementation
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindAuthRepository(
        impl: AuthRepositoryImplementation
    ): AuthRepository
}
