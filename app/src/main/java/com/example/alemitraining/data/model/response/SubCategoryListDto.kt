package com.example.alemitraining.data.model.response

import com.example.alemitraining.page.model.SubCategoryList
import com.example.alemitraining.page.response.SubCategoryItemDto
import com.example.alemitraining.page.response.toSubCategoryItem
import com.google.gson.annotations.SerializedName
import kotlin.math.max

class SubCategoryListDto(
    @SerializedName("categoryItems") val categoryItems: List<SubCategoryItemDto>
)

fun SubCategoryListDto.toSubCategoryList(): SubCategoryList {
    return SubCategoryList(
        categoryItems = categoryItems.map { it.toSubCategoryItem() }
    )
}