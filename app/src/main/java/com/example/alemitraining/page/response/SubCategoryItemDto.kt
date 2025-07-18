package com.example.alemitraining.page.response

import com.example.alemitraining.page.model.SubCategoryItem
import com.google.gson.annotations.SerializedName

class SubCategoryItemDto(
    @SerializedName("title") val title: String,
    @SerializedName("imageUrl") val imageUrl: String,
    @SerializedName("slug") val slug: String
)

fun SubCategoryItemDto.toSubCategoryItem(): SubCategoryItem {
    return SubCategoryItem(title, imageUrl, slug)
}