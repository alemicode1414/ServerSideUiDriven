package com.example.alemitraining.page.response

import com.example.alemitraining.data.model.response.SubCategoryListDto
import com.google.gson.annotations.SerializedName

data class PageRowDto(
    @SerializedName("subCategoryListItem") val subCategoryList: SubCategoryListDto?,
)