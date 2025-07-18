package com.example.alemitraining.data.model.response

import com.example.alemitraining.page.response.PageBodyDto
import com.google.gson.annotations.SerializedName

data class MerchantDetailsResponseDto(
    @SerializedName("title") val title: String,
    @SerializedName("description") val description: String,
    @SerializedName("logoUrl") val logoUrl: String,
    @SerializedName("coverUrl") val coverUrl: String?,
    @SerializedName("shareLink") val shareLink: String,
    @SerializedName("pageBody") val pageBody: PageBodyDto,
)