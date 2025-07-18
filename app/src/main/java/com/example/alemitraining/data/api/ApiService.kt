package com.example.alemitraining.data.api

import com.example.alemitraining.data.model.response.MerchantDetailsResponseDto
import com.example.alemitraining.page.response.PageBodyDto
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @POST("experience/api/v1/merchant/{id}")
    suspend fun merchantDetails(@Path("id") id: String): MerchantDetailsResponseDto

    @POST("experience/api/v1/merchant/{id}/page-body")
    suspend fun merchantPageBody(
        @Path("id") id : String,
        @Query("page") cursor : String
    ) : PageBodyDto
}