package com.example.alemitraining.data.datasource.remote

import com.example.alemitraining.data.model.response.MerchantDetailsResponseDto
import com.example.alemitraining.domain.model.MerchantRepository
import com.example.alemitraining.page.response.PageBodyDto
import javax.inject.Inject

class MerchantRepositoryImpl @Inject constructor(
    private val dataSource: MerchantRemoteDataSource
) : MerchantRepository {
    override suspend fun getMerchantDetails(merchantId: String): Result<MerchantDetailsResponseDto> {
        return dataSource.getMerchantDetails(merchantId)
    }

    override suspend fun getPageBody(merchantId: String, cursor: String): Result<PageBodyDto> {
        return dataSource.getPageBody(merchantId, cursor)
    }
}