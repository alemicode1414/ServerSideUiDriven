package com.example.alemitraining.data.datasource.remote

import com.example.alemitraining.data.api.ApiService
import com.example.alemitraining.data.model.response.MerchantDetailsResponseDto
import com.example.alemitraining.data.model.response.SubCategoryListDto
import com.example.alemitraining.page.response.PageBodyDto
import com.example.alemitraining.util.safeApiCall
import javax.inject.Inject

class MerchantRemoteDataSource @Inject constructor(
    private val merchantDetailsService: ApiService
) {
    suspend fun getMerchantDetails(merchantId: String): Result<MerchantDetailsResponseDto> {
        return safeApiCall {
            merchantDetailsService.merchantDetails(merchantId)
        }
    }

    suspend fun getPageBody(merchantId: String, cursor: String): Result<PageBodyDto> {
        return safeApiCall {
            merchantDetailsService.merchantPageBody(merchantId, cursor)
        }
    }
}