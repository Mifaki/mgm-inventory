package com.brawijaya.mgminventory.data.module

import android.content.Context
import com.brawijaya.mgminventory.data.module.retrofit.TokenInterceptor
import com.brawijaya.mgminventory.data.service.auth.local.TokenStorage
import com.brawijaya.mgminventory.data.service.auth.remote.AuthApi
import com.brawijaya.mgminventory.data.service.borrow.remote.BorrowApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Named("BaseUrl")
    fun provideBaseUrl(): String = "https://mgm-inventory-be.vercel.app/api/v1/"

    @Provides
    @Singleton
    fun provideAuthInterceptor(tokenStorage: TokenStorage): TokenInterceptor {
        return TokenInterceptor(tokenStorage)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(authInterceptor: TokenInterceptor): OkHttpClient {
        val logging = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        return OkHttpClient.Builder()
            .addInterceptor(authInterceptor)
            .addInterceptor(logging)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        client: OkHttpClient,
        @Named("BaseUrl") baseUrl: String
    ): Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    @Provides
    @Singleton
    fun provideAuthApi(retrofit: Retrofit): AuthApi =
        retrofit.create(AuthApi::class.java)

    @Provides
    @Singleton
    fun provideBorrowApi(retrofit: Retrofit): BorrowApi =
        retrofit.create(BorrowApi::class.java)

    @Provides
    @Singleton
    fun provideTokenManager(
        @ApplicationContext context: Context
    ): TokenStorage = TokenStorage(context)
}
