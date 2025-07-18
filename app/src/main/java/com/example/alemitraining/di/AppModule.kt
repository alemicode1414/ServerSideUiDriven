package com.example.alemitraining.di

import com.example.alemitraining.data.api.ApiService
import com.example.alemitraining.data.datasource.remote.MerchantRemoteDataSource
import com.example.alemitraining.data.datasource.remote.MerchantRepositoryImpl
import com.example.alemitraining.domain.model.MerchantRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApiService(): ApiService =
        Retrofit.Builder()
            .baseUrl("https://test.com/")
            .build()
            .create(ApiService::class.java)

    @Provides
    @Singleton
    fun provideMerchantRepository(dataSource: MerchantRemoteDataSource): MerchantRepository =
        MerchantRepositoryImpl(dataSource)

    @Provides
    @Singleton
    fun provideMerchantDataSource(apiService: ApiService): MerchantRemoteDataSource {
        return MerchantRemoteDataSource(apiService)
    }

}