package com.example.alemitraining.domain.model

import com.example.alemitraining.data.model.response.MerchantDetailsResponseDto
import com.example.alemitraining.page.response.PageBodyDto
import com.example.alemitraining.util.safeApiCall

interface MerchantRepository {

    suspend fun getMerchantDetails(merchantId: String): Result<MerchantDetailsResponseDto>

    suspend fun getPageBody(merchantId: String, cursor: String): Result<PageBodyDto>
}