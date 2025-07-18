package com.example.alemitraining.page.response

import com.example.alemitraining.page.model.MerchantBanner
import com.google.gson.annotations.SerializedName

class MerchantBannerDto(
    @SerializedName("id") val id: String,
    @SerializedName("title") val title: String,
    @SerializedName("slug") val slug: String,
    @SerializedName("merchantImageUrl") val merchantImageUrl: String,
    @SerializedName("imageUrls") val images: List<String>
)

fun MerchantBannerDto.toMerchantBanner(): MerchantBanner {
    return MerchantBanner(
        id,
        title,
        slug,
        merchantImageUrl,
        images,
    )
}